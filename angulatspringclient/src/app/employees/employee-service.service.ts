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

  getEmployee(id : number) : Observable<Object> {
    return this.http.get(`${this.employeeURL}/${id}`)
  }

  createEmployee(employee : Object) : Observable<Object> {
    return this.http.post(this.employeeURL, employee);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.employeeURL}/${id}`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.employeeURL}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.employeeURL}`);
  }
}
