import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  allUsers: User[] = [];
  newUser: User = {
    id: '',
    email: '',
    first_name: '',
    last_name: '',
    avatar: ''
  };

  constructor(private service:UserService) { }

  ngOnInit(): void {
    this.service.getAllUsers()
    .subscribe((data:User[])=>{
    this.allUsers=data;
    console.log(this.allUsers);
    });
  }

  myError(){
    console.log('inside myError function');
    return throwError('new error thrown');
  }

  createUser(){
      this.service.getNewUser().subscribe((data: User)=>{
      this.newUser=data;
      console.log(this.newUser);
      });
  }
}
