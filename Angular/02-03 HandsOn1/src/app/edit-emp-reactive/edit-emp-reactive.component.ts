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
    this.showSuccess = true;
  }

}
