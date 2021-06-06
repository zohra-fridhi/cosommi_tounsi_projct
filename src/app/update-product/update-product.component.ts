import { Component, OnInit } from '@angular/core';
import {Product} from '../product';
import {ActivatedRoute, Router, RouterModule} from '@angular/router';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
product: any;
  constructor(private router: Router, private service: ProductService, private rout: ActivatedRoute) { }

  ngOnInit(): void {
    this.product = new Product()
    this.getOne()
  }
  getOne(){
    return this.service.getProId(this.rout.snapshot.params['id']).subscribe((data)=>this.product=data);
  }
  onSubmit(){
    return this.service.updateProduct(this.rout.snapshot.params['id'],this.product).subscribe(data=>this.goToProductList());

  }
  goToProductList(){
    this.router.navigate(['/listProduct']);
  }
}
