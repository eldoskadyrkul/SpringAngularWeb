import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Employee } from "./model/employee";
import { Observable } from "rxjs";

@Injectable()
export class EmployeeServiceService {

  private employeeURL: string;

  constructor(private http:  HttpClient) {
    this.employeeURL = "http://localhost:8080/employees";
  }

  public findAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeURL);
  }

  public saveEmployee(employee: Employee) {
    return this.http.post<Employee[]>(this.employeeURL, employee);
  }

}
