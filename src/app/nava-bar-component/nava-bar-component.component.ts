import { Component, OnInit } from '@angular/core';
import {Product} from '../product';
import {Router} from '@angular/router';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-nava-bar-component',
  templateUrl: './nava-bar-component.component.html',
  styleUrls: ['./nava-bar-component.component.css']
})
export class NavaBarComponentComponent implements OnInit {
product: Product[];
name: string;
  constructor(private router: Router, private service: ProductService) { }

  ngOnInit(): void {
    this.service.getProducts().subscribe( (data: Product[]) => this.product = data);
  }
goToSerach(){
    this.router.navigate(['/search-Product']);
}
Search(){
    if(this.name == ""){
      this.ngOnInit();
    }else {
      this.product=this.product.filter(res =>{return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());});
    }
}
}
