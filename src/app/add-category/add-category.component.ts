import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../categorie/service.service';
import {Categorie} from '../categorie';
import {Product} from '../product';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {
categ: Categorie
  constructor(private service: ServiceService) { }

  ngOnInit(): void {
  this.categ=new Categorie()
  }
addCateg(cat: Categorie){
    this.service.addCategory(cat).subscribe((data: Categorie) => this.categ = data)
}
}
