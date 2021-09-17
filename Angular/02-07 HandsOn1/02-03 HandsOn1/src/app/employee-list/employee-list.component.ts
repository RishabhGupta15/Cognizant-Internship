import { Component, OnInit } from '@angular/core';
import { Employee } from '../view-emp/employee';
import { Department } from '../view-emp/department';
import { Skill } from '../view-emp/skill';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employeeList: Employee[] = [
    {id:1, name: 'Rishabh',
    salary:10000, 
    permanent:true, 
    department: {id: 1, name: 'payroll'}, 
    skills:[{id:1, name:'HTML'},{id:2, name:'CSS'},{id:3, name:'JS'} ],
    dob: new Date("1999-12-11")
    },
    {id:1, name: 'John',
    salary:10000, 
    permanent:true, 
    department: {id: 1, name: 'payroll'}, 
    skills:[{id:1, name:'HTML'},{id:2, name:'CSS'},{id:3, name:'JS'} ],
    dob: new Date("1999-12-11")
    },
    {id:1, name: 'Smith',
    salary:10000, 
    permanent:true, 
    department: {id: 1, name: 'payroll'}, 
    skills:[{id:1, name:'HTML'},{id:2, name:'CSS'},{id:3, name:'JS'} ],
    dob: new Date("1999-12-11")
    },
    {id:1, name: 'Mary',
    salary:10000, 
    permanent:true, 
    department: {id: 1, name: 'payroll'}, 
    skills:[{id:1, name:'HTML'},{id:2, name:'CSS'},{id:3, name:'JS'} ],
    dob: new Date("1999-12-11")
    },
    {id:1, name: 'Leonard',
    salary:10000, 
    permanent:true, 
    department: {id: 1, name: 'payroll'}, 
    skills:[{id:1, name:'HTML'},{id:2, name:'CSS'},{id:3, name:'JS'} ],
    dob: new Date("1999-12-11")
    }
    
  ];

  searchInput: string = '';
  resultEmployee: Employee[] = [];
  showResultDiv: boolean = false;

  

  constructor() { }

  searchResult(){
    console.log("in searchResult function");
    let names: string[] = [];
    let result: string[] = [];
    for(let employee of this.employeeList){
      names.push(employee.name);
    }
    for(let name of names){
      if(name.indexOf(this.searchInput) != -1){
        result.push(name);
        console.log(name);
      }
    }
    for(let employee of this.employeeList){
      if(result.includes(employee.name)){
        this.resultEmployee.push(employee);
      }
    }
    if(this.resultEmployee.length > 0){
      this.showResultDiv = true;
    }
  }

  ngOnInit(): void {
  }

}
