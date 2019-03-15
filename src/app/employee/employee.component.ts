import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
// import { Filterdata} from '../filterdata';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employee : Observable<Employee[]>
  employees:Employee[] = [];
  // empId : string;
  // empMgrId  :string;
  constructor(private employeeService : EmployeeService, private router : Router) {
    this.employee = employeeService.getEmployees();
    // this.empId = "empId";
    // this.empMgrId ="empMgrId";
   }
   login( empId,empMgrId ) {
     localStorage.setItem("empId",empId);
     localStorage.setItem("empMgrId",empMgrId);
     this.router.navigate(["/login"]);
   }

  ngOnInit() {
    this.employeeService.getEmployees().subscribe(c => this.employees = c); 
  }

}
