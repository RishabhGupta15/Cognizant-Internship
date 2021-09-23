import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEmpComponent } from './view-emp/view-emp.component';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
import { QuantityIncrementComponent } from './quantity-increment/quantity-increment.component';
import { EditEmpTemplateDrivenComponent } from './edit-emp-template-driven/edit-emp-template-driven.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EditEmpReactiveComponent } from './edit-emp-reactive/edit-emp-reactive.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth/auth.guard';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
const routes: Routes = [
  {path: 'view-emp', component: ViewEmpComponent},
  {path: 'edit-emp', component: EditEmpComponent},
  {path: 'quality-inc', component: QuantityIncrementComponent},
  {path: 'edit-emp-templete-driven', component: EditEmpTemplateDrivenComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'edit-emp-reactive', component: EditEmpReactiveComponent, canActivate:[AuthGuard]},
  {path: 'user', component: UserComponent},
  {path: 'login',component: LoginComponent},
  {path: 'create-user', component:CreateUserComponent},
  {path: 'update-user', component:UpdateUserComponent},
  {path: 'delete-user', component:DeleteUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
