import { Component, OnInit } from '@angular/core';
import {Categorie} from '../categorie';
import {ServiceService} from '../categorie/service.service';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
cat: Categorie[];
  name: any;
  catId: number;
  constructor(private service: ServiceService, private ser: ProductService, private route: Router, private rout: ActivatedRoute) { }

  ngOnInit(): void {
  this.service.getCategories().subscribe((data:Categorie[]) => this.cat= data);
  }

  goToProductName(catId){
   this.route.navigate(['product-Name',catId]);
  }
  deleteCatByID(id: number){
    this.service.deleteCategorie(id).subscribe(() => this.service.getCategories().subscribe(res => this.cat = res));
  }
}
