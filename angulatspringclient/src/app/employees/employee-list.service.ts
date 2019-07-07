import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EmployeeList} from "./model/employee-list";

@Injectable()
export class EmployeeListService {

  private employeeURL: string;

  constructor(private http:  HttpClient) {
    this.employeeURL = "http://localhost:8080/employeesList";
  }

  getEmployeeList() : Observable<any> {
    return this.http.get(this.employeeURL);
  }

  public findAll(): Observable<EmployeeList[]> {
    return this.http.get<EmployeeList[]>(this.employeeURL + "/find");
  }

  public saveEmployee(employee: EmployeeList) {
    return this.http.post<EmployeeList[]>(this.employeeURL + "/create", employee);
  }

  public updateEmployee(id: number, value: any) : Observable<Object> {
    return this.http.put(this.employeeURL + "/${id}", value);
  }

  public deleteEmployee(id : number) : Observable<any> {
    return this.http.delete(this.employeeURL + '/${id}', {responseType : "text"});
  }
}
