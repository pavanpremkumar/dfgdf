import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LeaveDetails } from '../leave-details';
import { LeaveDetailsService } from '../leave-details.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-leave-history',
  templateUrl: './leave-history.component.html',
  styleUrls: ['./leave-history.component.css']
})
export class LeaveHistoryComponent implements OnInit {
  empNo : number;
  page : number =1;
  totalRec : number;
  leavedetails : Observable<LeaveDetails[]>;
  lhistory:LeaveDetails[] = [];
  
  constructor(private leaveDetailsService : LeaveDetailsService, private _router : Router) { 
    this.empNo = parseInt(localStorage.getItem("empId"));
    this.leavedetails = leaveDetailsService.searchLeaveHistory(this.empNo);
    this.leavedetails.subscribe(result => {this.totalRec = result.length;})
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
  edit(leId){
    localStorage.setItem("leId",leId);
    this._router.navigate(["/editleave"]);
    
  }
  ngOnInit() {
    this.leaveDetailsService.searchLeaveHistory(this.empNo).subscribe(res => {this.lhistory = res});
    
  }

}
