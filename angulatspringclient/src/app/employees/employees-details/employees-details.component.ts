import {Component, Input, OnInit} from '@angular/core';
import {Employee} from "../model/employee";
import {EmployeeServiceService} from "../employee-service.service";
import {EmployeeListComponent} from "../employee-list/employee-list.component";

@Component({
  selector: 'app-employees-details',
  templateUrl: './employees-details.component.html',
  styleUrls: ['./employees-details.component.css']
})
export class EmployeesDetailsComponent implements OnInit {

  @Input() employee : Employee;

  constructor(private employeeService : EmployeeServiceService, private listComponent : EmployeeListComponent) { }

  ngOnInit() {
  }

}
