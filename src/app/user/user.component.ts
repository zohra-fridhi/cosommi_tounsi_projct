import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import {UserService} from '../serviceU/user.service';
import {PublicityService} from '../servieP/publicity.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
user: User[]
  constructor(private service: UserService,private route: Router) { }

  ngOnInit(): void {
  this.service.getUsers().subscribe((data:User[])=>this.user=data);
  }
  getPubUser(age){
    this.route.navigate(['pubUser',age]);
  }
}
