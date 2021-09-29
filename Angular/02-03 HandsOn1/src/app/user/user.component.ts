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
  jsondata = {};
  
  constructor(private service:UserService) { }

  ngOnInit(): void {  
    this.service.getAllUsers()
    .subscribe((data:any)=>{
    this.allUsers=data.data;
    });
    
  }

  myError(){
    console.log('inside myError function');
    return throwError('new error thrown');
  }

}
