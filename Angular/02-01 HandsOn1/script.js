var employee = {"firstname":"John", "lastname":"Stoke", "Salary":5000, "permanet_staff":true};
console.log(employee);

console.log("reading from json file")
var readJson = JSON.stringify(emp);
console.log(readJson);

var empObj = JSON.parse(readJson);
console.log("Iterating skills");

var skillsOfEmp = empObj['skills'];
for(let i=0; i<skillsOfEmp.length; i++){
    console.log(skillsOfEmp[i]);
}
