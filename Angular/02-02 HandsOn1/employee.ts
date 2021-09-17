import {Skill} from './skill';
export interface Employee{
    id:number,
    name:string,
    salary:number,
    permanent:boolean,
    skills:Skill[]
}
