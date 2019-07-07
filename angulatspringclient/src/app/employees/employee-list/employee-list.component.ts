import { Component, OnInit } from '@angular/core';
import { Employee } from "../model/employee";
import { EmployeeServiceService } from "../employee-service.service";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employee : Employee[];

  constructor(private EmployeeService: EmployeeServiceService) { }

  ngOnInit() {
    this.EmployeeService.findAll().subscribe(data => [
      this.employee = data
    ]);
  }

}
