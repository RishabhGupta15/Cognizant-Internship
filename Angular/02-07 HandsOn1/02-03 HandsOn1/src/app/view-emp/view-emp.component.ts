import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { Skill } from './skill';

@Component({
  selector: 'app-view-emp',
  templateUrl: './view-emp.component.html',
  styleUrls: ['./view-emp.component.css']
})
export class ViewEmpComponent implements OnInit {

  constructor() { }
  title = 'hello-world';
  employee1: Employee = {id:1, name: 'Rishabh', salary:10000, permanent:true, department: {id: 1, name: 'payroll'}, skills:[{id:1, name:'HTML'},{id:2, name:'CSS'},{id:3, name:'JS'} ],dob: new Date("1999-12-11")};
  skillSet: Skill[] = this.employee1['skills'];

  ngOnInit(): void {
  }

}
