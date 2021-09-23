import { Component, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { ViewEmpComponent } from './view-emp/view-emp.component';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
import { QuantityIncrementComponent } from './quantity-increment/quantity-increment.component';
import { EditEmpTemplateDrivenComponent } from './edit-emp-template-driven/edit-emp-template-driven.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeInfoComponent } from './employee-list/employee-info/employee-info.component';
import { EditEmpReactiveComponent } from './edit-emp-reactive/edit-emp-reactive.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { CardComponent } from './card/card.component';

// const routes: Routes = [
//   {path: '', component: AppComponent},
//   {path:'view-emp', component: ViewEmpComponent}
// ];

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    ViewEmpComponent,
    EditEmpComponent,
    QuantityIncrementComponent,
    EditEmpTemplateDrivenComponent,
    EmployeeListComponent,
    EmployeeInfoComponent,
    EditEmpReactiveComponent,
    UserComponent,
    LoginComponent,
    CreateUserComponent,
    UpdateUserComponent,
    DeleteUserComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,FormsModule,ReactiveFormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
