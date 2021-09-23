import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
 
  newUser: User = {
    id: "",
    email: "",
    first_name: "",
    last_name: "",
    avatar: ""
  };
  constructor(private service:UserService) { }

  ngOnInit(): void {
    this.service.getNewUser().subscribe((data:User)=> {
      this.newUser=data;
    });
  }

}
