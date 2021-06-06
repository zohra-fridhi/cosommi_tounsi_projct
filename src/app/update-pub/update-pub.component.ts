import { Component, OnInit } from '@angular/core';
import {Publicity} from '../publicity';
import {PublicityService} from '../servieP/publicity.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../product';

@Component({
  selector: 'app-update-pub',
  templateUrl: './update-pub.component.html',
  styleUrls: ['./update-pub.component.css']
})
export class UpdatePubComponent implements OnInit {
pub: Publicity
  constructor(private service: PublicityService, private rout: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.pub = new Publicity()
  this.getOne();
  }
  getOne(){
    return this.service.getPubId(this.rout.snapshot.params['id']).subscribe((data:Publicity)=>this.pub=data);
  }
  onSubmit(){
    return this.service.updatePub(this.rout.snapshot.params['id'],this.pub).subscribe(data=>this.goToPubList());

  }
  goToPubList(){
    this.router.navigate(['/listPublicities']);
  }

}
