import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CategoriesComponent} from '../categories/categories.component';
import {Categorie} from '../categorie';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }
  getCategories(){
   return this.http.get<Categorie[]>('http://localhost:8081/SpringMVC/servlet/category/display');
  }
  deleteCategorie(id:number){
    return this.http.delete('http://localhost:8081/SpringMVC/servlet/category/delete/' + id);
  }
  addCategory(cat: Categorie){
    return this.http.post('http://localhost:8081/SpringMVC/servlet/category/add' , cat);
  }
}
