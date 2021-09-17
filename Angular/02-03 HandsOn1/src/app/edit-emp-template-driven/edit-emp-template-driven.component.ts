import { Component, OnInit } from '@angular/core';
import { Employee } from '../view-emp/employee';
import { Department } from '../view-emp/department';
import { Skill } from '../view-emp/skill';

@Component({
  selector: 'app-edit-emp-template-driven',
  templateUrl: './edit-emp-template-driven.component.html',
  styleUrls: ['./edit-emp-template-driven.component.css']
})
export class EditEmpTemplateDrivenComponent implements OnInit {

  inputName: string = '';
  showDanger: boolean = false;
  inputSalary: number = 0.0;
  isPermanent: boolean = false;
  departments: Department[] = [
    { id:1, name:"Payroll" },
    { id:2, name:"Internal" },
    { id:3, name:"HR" }
  ];
  emp: Employee = {
    id: 1,
    name: 'John',
    salary: 2000,
    permanent: true,
    department: this.departments[0],
    skills: [{id:1, name:"html"}, {id:2, name:"css"}],
    dob: new Date('12/12/1999')
  };
  inputDepartment: number = 0;
  successShow: boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  readInput(event: any){
    this.inputName = event.target.value;
  }

  checkInputName(){ 
    if(this.inputName.length < 2 || this.inputName.length > 10){
      this.showDanger = true;
    }
    else{
      this.showDanger = false;
    }
  }

  setIsPermanent(value: boolean){
    this.isPermanent = value;
  }
  setValues(){
    this.emp.name = this.inputName;
    this.emp.salary = this.inputSalary;
    this.emp.permanent = this.isPermanent;
    for(let i = 0; i < this.departments.length; i++){
      if(this.inputDepartment == this.departments[i].id){
        this.emp.department = this.departments[i];
      }
    }
    this.successShow = true;
  }

}
