import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Usr } from './user/usr';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = 'https://reqres.in/api/users?page=2';

  constructor(private http:HttpClient) { }

  getAllUsers(){
      return this.http.get<User[]>(this.url);
  }

  handleError(error: any){
    return throwError(error);
  }

  getNewUser(){
    return this.http.get<User>('https://reqres.in/api/users/2');
  }

  putUpdateUser(user1: Usr){
    return this.http.put('https://reqres.in/', user1);
  }

}
