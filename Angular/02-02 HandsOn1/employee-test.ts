import {Employee} from './employee';
import {Skill} from './skill';
let emp1:Employee = {
    id:1,
    name:"Jon",
    salary:1000,
    permanent:true,
    skills:[{id:1, name:"HTML"}, {id:2, name:"CSS"}, {id:3, name:"JavaScript"}]
};
console.log(emp1);

console.log("iterating skills");

var empSkills:Skill[] = emp1['skills'];
for (var i=0; i<empSkills.length; i++ ){
    console.log(empSkills[i]);
}
