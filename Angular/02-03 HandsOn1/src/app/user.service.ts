import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = 'https://reqres.in/api/users?page=2';
  user = {
    "name": "morpheus",
    "job": "leader"
};
  

  constructor(private http:HttpClient) { }

  getAllUsers(){
      return this.http.get<User[]>(this.url);
  }

  handleError(error: any){
    return throwError(error);
  }

  getNewUser(){
    return this.http.post<User>('https://reqres.in/api/users', this.user);
  }

  updateUser(){
    return this.http.put('https://reqres.in/api/users/2', this.user);
  }

}
