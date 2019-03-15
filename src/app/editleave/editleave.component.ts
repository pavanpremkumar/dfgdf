import { Component, OnInit } from '@angular/core';
import { Observable }from 'rxjs';
import { LeaveDetailsService }from"../leave-details.service";
import { EmployeeService }from"../employee.service";
import {Router} from '@angular/router';
import { Employee }from "../employee";
import { LeaveDetails }from"../leave-details";
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-editleave',
  templateUrl: './editleave.component.html',
  styleUrls: ['./editleave.component.css']
})
export class EditleaveComponent implements OnInit {
  leav : Observable<LeaveDetails>;
  empno : number;
  obj : LeaveDetails;
  msg : String;
  isValidFormSubmitted : boolean;
  constructor(private leaveDetailsService: LeaveDetailsService,
    private employeeService: EmployeeService,
    private _router : Router) 
    {
this.empno = parseInt(localStorage.getItem("empId"));
this.obj = new LeaveDetails();
// alert("Employ ID " +this.empno);

 }
 calculateDays() {
  let date1: string=this.obj.levStartDate.toString();
  let date2: string=this.obj.levEndDate.toString();
  let diffInMs: number = Date.parse(date2) - Date.parse(date1);
  let diffInHours: number = diffInMs / 1000 / 60 / 60/24;
  this.obj.levNoOfDays=diffInHours + 1;
  
 // alert(diffInHours);
  //console.log(diffInHours);

  //alert("Event Fired");
 }
 apply(form : NgForm)
 {
     this.isValidFormSubmitted=false;
     if(form.invalid){
    //     alert("Invalid");
      return; 
   }  
 console.log ('end date component' + this.obj.levEndDate);
 this.leaveDetailsService.editLeaves(this.obj.levId, this.obj).subscribe(
     success => {
         this.msg=success;
     },
     err => { 
         this.msg=err;
         console.log(err);
     }
 )
 this.isValidFormSubmitted = true;
 setTimeout(() => {
   this._router.navigate(['/DashBoard'])
 }, 1000000);
 }
 cancel(){
  this._router.navigate(['/history'])
 }
  ngOnInit() {
  }

}
