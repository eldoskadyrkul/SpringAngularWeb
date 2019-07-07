import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {EmployeeServiceService} from "../employee-service.service";
import {Router} from '@angular/router';
import {Employee} from "../model/employee";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Observable<Employee[]>

  constructor(private employeeService: EmployeeServiceService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }

  deleteEmployee(id : number) {
    this.employeeService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error1 => console.log(error1)
      );
  }

}
