import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Department } from '../view-emp/department';
import { Employee } from '../view-emp/employee';
import { Skill } from '../view-emp/skill';

@Component({
  selector: 'app-edit-emp',
  templateUrl: './edit-emp.component.html',
  styleUrls: ['./edit-emp.component.css']
})
export class EditEmpReactiveComponent implements OnInit {

  constructor() { }

  departments: Department[] = [
    { id:1, name:"Payroll" },
    { id:2, name:"Internal" },
    { id:3, name:"HR" }
  ];

  empForm = new FormGroup({
    name: new FormControl(),
    salary: new FormControl(),
    permanent: new FormControl(),
    departmentId: new FormControl()
  });

  ngOnInit(): void {
  }

}
