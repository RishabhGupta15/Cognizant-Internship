class Employee{
    constructor(name, designation, year_of_experience){
       this.name = name;
       this.designation = designation;
       this.year_of_experience = year_of_experience;
   }
}

function createEmployee(name, designation, year_of_experience){
   var emp1 = new Employee(name, designation, year_of_experience);
   return emp1;
}

function validateObject(employee){
   var msg = '';
   if(employee instanceof Employee){
       var currentDate = new Date();
       var currentYear = currentDate.getFullYear();
       var joiningYear = currentYear - employee.year_of_experience - 1;
       msg = employee.name + ' is serving the ' + 'position of ' + employee.designation + ' since ' + joiningYear;
   }
   return msg;
}

function displayEmployee(name, designation, year_of_experience){
   var emp = createEmployee(name, designation, year_of_experience);
   return validateObject(emp);
}

console.log(displayEmployee("Jerold","Manager",15));