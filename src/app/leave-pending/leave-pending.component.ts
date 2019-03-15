import { Component, OnInit } from '@angular/core';
import { Observable }from 'rxjs';
import { LeaveDetailsService }from"../leave-details.service";
import {Router} from '@angular/router';
import { Employee }from "../employee";
import { LeaveDetails }from"../leave-details";
import { EmployeeService }from"../employee.service";

// import { LeaveHistory } from './leave-history';



@Component({
  selector: 'app-leave-pending',
  templateUrl: './leave-pending.component.html',
  styleUrls: ['./leave-pending.component.css']
})
export class LeavePendingComponent implements OnInit {
  edata  : Observable<Employee[]>;
  leaves : Observable<LeaveDetails[]>;
  lpending:LeaveDetails[] = [];
  
  empno : number;
  order : string = 'levStartDate';
  reverse : boolean = true;
  sempno : string = 'empID';
  rever : boolean = false;
  demo : boolean = false;
  flag:boolean;
  levIdList = [];
  empList = [];
  
  
  show(levId,empId) {
  localStorage.setItem("levId",levId);
  localStorage.setItem("lEmpId",empId);
  this.flag=true;
  }

  constructor(private leaveDetailsService: LeaveDetailsService, private employeeService: EmployeeService,
              private _router : Router) {
    this.empno = parseInt(localStorage.getItem("empId"));
    this.leaves = leaveDetailsService.getPendingLeaves(this.empno);
    this.edata = employeeService.getEmployees();
    this.flag=false;
  }

  obj : LeaveDetails;
  mgrId : number;
  status : string;
  message : String;
  approveAll() {
    this.status = "YES";
    this.mgrId = parseInt(localStorage.getItem("empId"));
    this.obj = new LeaveDetails();
    let str = this.empList.toString();
    let res = str.split(',');
    for(var v in res) {
      this.obj.levId=parseInt(res[v]);
      this.obj.levMgrComments = "Leave Approved..";
      this.leaveDetailsService.approveDeny(this.mgrId,this.status,this.obj).subscribe(
        dd => {this.message=dd;
        },
        errorMsg => {
          this.message = errorMsg;
          console.log(errorMsg)
        }
      )
    } 
    setTimeout(() => {
      this._router.navigate(['/DashBoard'])
    }, 5000000);
  }

  

  checkbox(levId) {
    var res1 = levId + " ";
    this.empList.push(res1);
  }

  appDen() {
    this._router.navigate(["/appDen"]);
      }

  setOrder(value: string) {
    if(this.order === value) {
      this.reverse = !this.reverse;
    }

    this.order = value;
  }
  tat(stdate) : number { 
    let today = new Date();
    let diffInMs: number = Date.parse(stdate) - Date.parse(today.toDateString());
    let diffInHours: number = Math.floor(diffInMs / 1000 / 60 / 60 / 24);
    
    return diffInHours;

  }
  
  history() {
    this._router.navigate(["/history"]);
  }
  apply() {
    this._router.navigate(["/applyLeave"]);
  }
  pending() {
    this._router.navigate(["/pending"]);
  }
  dashboard(){
    this._router.navigate(["/DashBoard"]);
  }
  employee(){
    this._router.navigate([""]);
  }
  ngOnInit() {
    this.leaveDetailsService.getPendingLeaves(this.empno).subscribe(res => {this.lpending = res});
    
  }

}