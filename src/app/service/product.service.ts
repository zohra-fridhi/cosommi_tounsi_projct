import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../product';
import * as url from 'url';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
prod: Product;

  constructor(private http: HttpClient) { }
  getProducts(){
    return this.http.get<Product[]>( 'http://localhost:8081/SpringMVC/servlet/api/v1/getAll');
  }
  deleteProductById(id: number){
    return this.http.delete('http://localhost:8081/SpringMVC/servlet/api/v1/products/' + id);
}
addProduct(prod: Product){
    console.log(prod)
    return this.http.post('http://localhost:8081/SpringMVC/servlet/api/v1/products' , prod);
  }
  getProId(id: number){
    return this.http.get('http://localhost:8081/SpringMVC/servlet/api/v1/products/' + id);
  }
  updateProduct(id: number,prod: Product){
    return this.http.put('http://localhost:8081/SpringMVC/servlet/api/v1/products/' + id, prod);
  }
orderProduct(){
    return this.http.get('http://localhost:8081/SpringMVC/servlet/api/v1/Order');
}
getProductName(id: number){
    return this.http.get<string>('http://localhost:8081/SpringMVC/servlet/api/v1/Category/' +id);
}

}
