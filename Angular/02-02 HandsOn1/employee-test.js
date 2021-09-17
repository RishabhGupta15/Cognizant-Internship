"use strict";
exports.__esModule = true;
var emp1 = {
    id: 1,
    name: "Jon",
    salary: 1000,
    permanent: true,
    skills: [{ id: 1, name: "HTML" }, { id: 2, name: "CSS" }, { id: 3, name: "JavaScript" }]
};
console.log(emp1);
console.log("iterating skills");
var empSkills = emp1['skills'];
for (var i = 0; i < empSkills.length; i++) {
    console.log(empSkills[i]);
}
