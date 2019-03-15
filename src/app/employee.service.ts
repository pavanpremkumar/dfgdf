import { Injectable } from '@angular/core';
import { Http, Response} from '@angular/http';
import { Observable }from 'rxjs';
import { Employee }from"./employee";
import 'rxjs/add/operator/map';


@Injectable()
export class EmployeeService {

    constructor(private http: Http) { }
    searchEmployee(empid : number) : Observable<Employee> {
      return this.http.get("http://localhost:8080/FTP114/api/employees/" +empid)
      .map((res: Response) => res.json());
    }
    getEmployees():Observable<Employee[]> {
      return this.http.get("http://localhost:8080/FTP114/api/employees")
      .map((res: Response) => res.json());
    }

}
