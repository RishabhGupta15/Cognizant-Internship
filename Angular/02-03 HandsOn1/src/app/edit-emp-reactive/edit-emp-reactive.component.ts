import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Employee } from '../view-emp/employee';
import { Department } from '../view-emp/department';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-emp-reactive',
  templateUrl: './edit-emp-reactive.component.html',
  styleUrls: ['./edit-emp-reactive.component.css']
})
export class EditEmpReactiveComponent implements OnInit {

  constructor(private router:Router) { }

  departments: Department[] = [
    {id: 1, name: 'Payroll'},
    {id: 2, name: 'Internal'},
    {id: 3, name: 'HR'}
  ];

  employee1: Employee = {
    id: 1,
    name: 'John',
    salary: 200,
    permanent: false,
    department: this.departments[2],
    skills: [{id:1, name:'html'}, {id:2, name:'css'}],
    dob: new Date('11/10/1999')
  };

  

  empEditForm: FormGroup = new FormGroup({
    name: new FormControl('',[Validators.required, Validators.minLength(4), Validators.maxLength(20 )]),
    salary: new FormControl(''),
    isPermanent: new FormControl(''),
    departmentId: new FormControl('')
  });

  showSuccess: boolean = false;

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.empEditForm.value);
    console.log(this.employee1);
    this.employee1.name = this.empEditForm.get('name')?.value;
    this.employee1.salary = this.empEditForm.get('salary')?.value;
    this.employee1.permanent = this.empEditForm.get('isPermanent')?.value;
    let depId = this.empEditForm.get('departmentId')?.value
    for (let i of this.departments){
      if (i.id === depId){
        this.employee1.department = i;
      }
    }
    console.log(this.employee1);
    this.showSuccess = true;
  }

}
