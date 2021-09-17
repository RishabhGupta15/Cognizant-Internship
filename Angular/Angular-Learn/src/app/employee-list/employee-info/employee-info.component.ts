import { Component, OnInit, Input } from '@angular/core';
import { Employee } from 'src/app/view-emp/employee';

@Component({
  selector: 'app-employee-info',
  templateUrl: './employee-info.component.html',
  styleUrls: ['./employee-info.component.css']
})
export class EmployeeInfoComponent implements OnInit {

  @Input() employee: Employee = {id:1, name: 'Rishabh',
  salary:10000, 
  permanent:true, 
  department: {id: 1, name: 'payroll'}, 
  skills:[{id:1, name:'HTML'},{id:2, name:'CSS'},{id:3, name:'JS'} ],
  dob: new Date("1999-12-11")
  };

  constructor() { }

  ngOnInit(): void {
  }

}
