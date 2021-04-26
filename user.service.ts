import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from './user';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class UserService{
    private apiServerUrl = environment.apiBaseUrl;
    constructor(private http: HttpClient){}

    public getUsers(): Observable<User[]>{
        return this.http.get<User[]>('${this.apiServerUrl}/user/admin/all');
    }
    public addUser(user : User): Observable<User>{
        return this.http.post<User>('${this.apiServerUrl}/user/admin/add', user);
    }
    public updateUser(user : User): Observable<User>{
        return this.http.put<User>('${this.apiServerUrl}/user/admin/update', user);
    }
    public deleteUser(userId : number): Observable<void>{
        return this.http.delete<void>('${this.apiServerUrl}/user/admin/delete/${userId}');
    }
}
