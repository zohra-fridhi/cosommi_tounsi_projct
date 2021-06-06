import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {PublicityService} from '../servieP/publicity.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  res: any
  constructor(private route: ActivatedRoute, private service: PublicityService) { }

  ngOnInit(): void {
  this.route.snapshot.params['startAgeCible'];
  this.route.snapshot.params['endAgeCible'];
  this.route.snapshot.params['genderCible'];
  this.result()
  }
result(){
    this.service.countNbrUser(this.route.snapshot.params['startAgeCible'],
      this.route.snapshot.params['endAgeCible'],this.route.snapshot.params['genderCible']).subscribe((data:number)=>this.res=data);
}
}
