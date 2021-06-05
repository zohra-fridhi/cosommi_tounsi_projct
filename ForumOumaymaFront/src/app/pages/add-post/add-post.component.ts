import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {NgbDate} from '@ng-bootstrap/ng-bootstrap';
import {UtilityFunction} from '../../helpers/UtilityFunction';
import {User} from '../../models/user.mode';
import {PublicationModel} from '../../models/publication.model';
import {FormService} from '../../services/form.service';
import {CategoriesService} from '../../services/categories.service';
import {ToastrService} from 'ngx-toastr';
import './../../../assets/smtp.js';
declare let Email: any;
@Component({
  selector: 'app-user-profile',
  templateUrl: './add-post.component.html',
})
export class AddPostComponent implements OnInit {
  Categories$: any;
  // Form att
  pubForm: FormGroup;
  title: FormControl;
  content: FormControl;
  picture: FormControl;
  selectedFile: File;
  // User Details
  user: User;
  pubToCreate = new PublicationModel(this.authService.user);

  // Date att
  date: NgbDate;
  focusDate: boolean;
  userFile: File = null;
  public imagePath;
  imgURL: any;
  public message: string;
  private uploadFile$: Promise<any>;

  constructor(private authService: AuthService, private router: Router, private formService: FormService,
              private categorieService: CategoriesService,
              private toasterService: ToastrService) {
  }

  async ngOnInit() {
    this.getUser();
    this.createFormControls();
    this.createForm();
    this.Categories$ = await this.categorieService.getCategories().toPromise();
  }

  async getUser() {
    this.user = await UtilityFunction.getLoggedUserInfo(this.authService, this.router);
  }

  /** create form controle */
  createFormControls() {
    this.title = new FormControl(this.pubToCreate.title, [Validators.required]);
    this.content = new FormControl(this.pubToCreate.content, [ Validators.required, Validators.maxLength(150)]);
    this.picture = new FormControl(this.pubToCreate.picture, [Validators.required]);
  }

  /** create form validators */
  createForm() {
    this.pubForm = new FormGroup({
      title: this.title,
      id_categ: new FormControl(),
      content: this.content,
      picture: this.picture,
    });
  }

  isActive(date: NgbDate) {
    return date.equals(this.date);
  }


  // saveDate(date: NgbDate) {
  //   this.pubToCreate.date = new Date(date.year, date.month, date.day);
  // }

  mama($event: Event) {
    //
  }

  addPost() {
    this.formService.addPost(this.pubToCreate).subscribe(value => {
      this.pubToCreate = value;
      this.formService.uploadFile(this.userFile, this.pubToCreate.id).subscribe(
        () => {
          this.toasterService.success('Publication has been successfully added');
          this.notifyUser();
          this.router.navigate(['/form']);
        },
        (err) => this.toasterService.error('Upload Failed', err ));
    }, () => this.toasterService.error('Pblication is redunded'));
  }


  async onSelectFile(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.userFile = file;

      const mimeType = event.target.files[0].type;
      if (mimeType.match(/image\/*/) == null) {
        this.message = 'Only images are supported.';
        this.toasterService.warning(this.message);
        return;
      }

      const reader = new FileReader();

      this.imagePath = file;
      reader.readAsDataURL(file);
      reader.onload = (_event) => {
        this.imgURL = reader.result;
      };
    }


  }

  onSelectCateg(value: any) {
    this.pubToCreate.categoriePublications.id = value;
  }


  notifyUser(){
    Email.send({
      Host: 'smtp.elasticemail.com',
      Username: 'oumaima.ayadi1@esprit.tn',
      Password: '9672060A5AA898A56AC977AEB5CA1D4FA7C0',
      To: 'oumaima.ayadi1@esprit.tn',
      From: 'oumaima.ayadi1@esprit.tn',
      Subject: 'This is the subject',
      Body: 'And this is the body'
    }).then(
      message => alert(message)
    );
  }
}
