import { Component, OnInit } from '@angular/core';
import {Publicity} from '../publicity';
import {PublicityService} from '../servieP/publicity.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-pub-user',
  templateUrl: './pub-user.component.html',
  styleUrls: ['./pub-user.component.css']
})
export class PubUserComponent implements OnInit {
pub: Publicity[]
  constructor(private service: PublicityService, private route: ActivatedRoute) { }

  ngOnInit(): void {
  this.getPubUs(this.route.snapshot.params['age']);
  }
  getPubUs(age: number){
  this.service.getPubUser(this.route.snapshot.params['age']).subscribe((data:Publicity[])=>this.pub=data);
  }

}
