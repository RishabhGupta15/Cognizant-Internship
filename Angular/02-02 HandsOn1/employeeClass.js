"use strict";
exports.__esModule = true;
var EmployeeTest = /** @class */ (function () {
    function EmployeeTest(employee) {
        this.employee = employee;
    }
    EmployeeTest.prototype.display = function () {
        console.log(this.employee);
    };
    return EmployeeTest;
}());
var emp1 = {
    id: 1,
    name: "Jon",
    salary: 1000,
    permanent: true,
    skills: [{ id: 1, name: "HTML" }, { id: 2, name: "CSS" }, { id: 3, name: "JavaScript" }]
};
var emp = new EmployeeTest(emp1);
emp.display();
