import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Publicity} from '../publicity';
import {Product} from '../product';

@Injectable({
  providedIn: 'root'
})
export class PublicityService {

  constructor(private http: HttpClient) { }
  getPublicities(){
    return this.http.get<Publicity[]>('http://localhost:8081/SpringMVC/servlet/Publicity/displayAll');
  }
  getPubUser(age: number){
    return this.http.get<Publicity[]>('http://localhost:8081/SpringMVC/servlet/Publicity/PubUser/'+age);
  }
  getPubId(id: number){
    return this.http.get('http://localhost:8081/SpringMVC/servlet/Publicity/get/'+id);
  }
  updatePub(id: number,pub: Publicity){
    return this.http.put('http://localhost:8081/SpringMVC/servlet/Publicity/edit/' + id, pub);
  }
  deletePubById(id: number){
    return this.http.delete('http://localhost:8081/SpringMVC/servlet/Publicity/delete/' + id);
  }
  countNbrUser(startAgeCible: number, endAgeCible: number, genderCible: string){
    return this.http.get<number>('http://localhost:8081/SpringMVC/servlet/Publicity/Count/' +startAgeCible+'/'+endAgeCible+'/'+genderCible)
  }
}
