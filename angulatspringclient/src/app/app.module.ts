import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {RouterModule} from "@angular/router";
import { EmployeeListComponent } from './employees/employee-list/employee-list.component';
import { CreateEmployeesComponent } from './employees/create-employees/create-employees.component';
import { EmployeesDetailsComponent } from './employees/employees-details/employees-details.component';
import {FormsModule} from "@angular/forms";
import { AppRoutingModule } from './/app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    CreateEmployeesComponent,
    EmployeesDetailsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
