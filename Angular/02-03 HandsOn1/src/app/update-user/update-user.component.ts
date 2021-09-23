import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  updatedUser = {
     name: "",
     job: "",
     updatedAt: ""
  };

  
  constructor(private service:UserService) { }

  ngOnInit(): void {
    this.service.updateUser().subscribe((data: any)=> {
      this.updatedUser=data;
    });
  }

}
