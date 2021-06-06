import { Component, OnInit } from '@angular/core';
import {Product} from '../product';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-get-product',
  templateUrl: './get-product.component.html',
  styleUrls: ['./get-product.component.css']
})
export class GetProductComponent implements OnInit {
prod: Product[];
product: Product;
name: string;
id: number;
  constructor(private service: ProductService, private router: Router) { }

  ngOnInit(): void {
    this.service.getProducts().subscribe( (data: Product[]) => {this.prod = data; }, error => {console.log(error); });
  }
  Search(){
    if(this.name == ""){
      this.ngOnInit();
    }else {
      this.prod=this.prod.filter(res =>{return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());});
    }
  }
  deleteProductByID(id: number){
    this.service.deleteProductById(id).subscribe(() => this.service.getProducts().subscribe(res => this.prod = res));
  }

  goToUpdateProduct(id){
    this.router.navigate(['update-Product',id]);

 }
 Order(){
    this.service.orderProduct().subscribe((data:Product[])=>this.prod=data);
 }
}
