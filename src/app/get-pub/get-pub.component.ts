import {Component, OnInit, Pipe} from '@angular/core';
import {PublicityService} from '../servieP/publicity.service';
import {Publicity} from '../publicity';
import {DomSanitizer} from '@angular/platform-browser';
import {Router} from '@angular/router';

@Component({
  selector: 'app-get-pub',
  templateUrl: './get-pub.component.html',
  styleUrls: ['./get-pub.component.css']
})
export class GetPubComponent implements OnInit {

  Pub: Publicity[]
  age: number;
  constructor(private service: PublicityService,
              private sanitizer:DomSanitizer,private route: Router) { }

  ngOnInit(): void {
    this.service.getPublicities().subscribe((data:Publicity[])=>
    {
      this.Pub=data
      //this.Pub.map(elt => elt.image = "data:image/png;base64, "+elt.image)
    });
  }
goToUpdatePub(id: number){
    this.route.navigate(['updatePub',id]);
}
  deletePubByID(id: number){
    this.service.deletePubById(id).subscribe(() => this.service.getPublicities().subscribe(res => this.Pub = res));
  }


}

