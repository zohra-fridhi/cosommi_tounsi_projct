import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {Product} from '../product';
import {Categorie} from '../categorie';

@Component({
  selector: 'app-affect-prod',
  templateUrl: './affect-prod.component.html',
  styleUrls: ['./affect-prod.component.css']
})
export class AffectProdComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

  }

}
