import {Employee} from './employee';
import {Skill} from './skill';
class EmployeeTest{
    employee:Employee;
    constructor(employee:Employee){
        this.employee = employee;
    }

    display():void{
        console.log(this.employee);
    }
}
var emp1:Employee = {
    id: 1,
    name: "Jon",
    salary: 1000,
    permanent: true,
    skills: [{ id: 1, name: "HTML" }, { id: 2, name: "CSS" }, { id: 3, name: "JavaScript" }]
};
var emp = new EmployeeTest(emp1);
emp.display();
