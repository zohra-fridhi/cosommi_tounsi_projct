import { Component, OnInit } from '@angular/core';
import {Product} from '../product';
import {ProductService} from '../service/product.service';
import {Categorie} from '../categorie';
@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
product: Product;
categ: Categorie;
  constructor(private service: ProductService) { }

  ngOnInit(): void {
    this.product = new Product()
  }
ajouterProduit(product){
    this.service.addProduct(this.product).subscribe((data: Product) => this.product = data);
}
}
