import { Component, OnInit } from '@angular/core';
import {Publicity} from '../publicity';
import {PublicityService} from '../servieP/publicity.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-count',
  templateUrl: './count.component.html',
  styleUrls: ['./count.component.css']
})
export class CountComponent implements OnInit {
pub: Publicity

  constructor(private route: Router) { }

  ngOnInit(): void {
  this.pub=new Publicity()
  }
goTocount(startAgeCible: number,endAgeCible: number,genderCible: string){
  this.route.navigate(['result',startAgeCible,endAgeCible,genderCible]);
}
}
