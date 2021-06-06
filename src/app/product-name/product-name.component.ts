import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-name',
  templateUrl: './product-name.component.html',
  styleUrls: ['./product-name.component.css']
})
export class ProductNameComponent implements OnInit {
  name: any;
  constructor(private ser: ProductService, private rout: ActivatedRoute) { }

  ngOnInit(): void {
    this.getProductName(this.rout.snapshot.params['catId']);
  }
  getProductName(catId: number){
    this.ser.getProductName(this.rout.snapshot.params['catId']).subscribe(res=> this.name=res);
  }
}
