import { Component, OnInit } from '@angular/core';
import {Employee} from "../model/employee";
import {EmployeeServiceService} from "../employee-service.service";

@Component({
  selector: 'app-create-employees',
  templateUrl: './create-employees.component.html',
  styleUrls: ['./create-employees.component.css']
})
export class CreateEmployeesComponent implements OnInit {

  employee : Employee = new Employee();
  submitted = false;

  constructor(private employeeService : EmployeeServiceService) { }

  ngOnInit() {
  }

  newEmployee() : void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
    this.employeeService.createEmployee(this.employee)
      .subscribe(data => console.log(data), error1 => console.log(error1));
    this.employee = new Employee();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
