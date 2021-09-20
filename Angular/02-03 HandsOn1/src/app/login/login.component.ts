import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  username: string="";
  password: string="";

  submit(){
    if(this.username==='admin'&&this.password==='admin'){
      alert("login success");
      sessionStorage.setItem("loginstatus","success");
    }else{
      alert("login faild");
      sessionStorage.removeItem("loginstatus");
    }
  }
}
