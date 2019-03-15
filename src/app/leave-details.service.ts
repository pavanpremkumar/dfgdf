import { Injectable } from '@angular/core';
import { Http, Response} from '@angular/http';
import { Observable }from 'rxjs';
import { LeaveDetails }from"./leave-details";
import 'rxjs/add/operator/map';
@Injectable()

export class LeaveDetailsService {

  constructor(private http: Http) { }

  searchLeaveHistory(empid : number) : Observable<LeaveDetails[]> {
    return this.http.get("http://localhost:8080/FTP114/api/leavedetails/history/" +empid)
    .map((res: Response) => res.json());
  }
  getPendingLeaves(empid : number):Observable<LeaveDetails[]> {
    return this.http.get("http://localhost:8080/FTP114/api/leavedetails/pending/" +empid)
    .map((res: Response) => res.json());
  }
  getLeaves(levId : number):Observable<LeaveDetails> {
    return this.http.get("http://localhost:8080/FTP114/api/leavedetails/leave/" +levId)
    .map((res: Response) => res.json());
  }

  approveDeny(empId :number, status :string,leaveDetails : LeaveDetails ):Observable<string> {
    return this.http.post("http://localhost:8080/FTP114/api/leavedetails/approveDeny/"+empId+"/"+status,leaveDetails)
    .map((res: Response) => res.text());
  }

  applyLeave(empId :number, response :string,leaveDetails : LeaveDetails ):Observable<string> {
    return this.http.post("http://localhost:8080/FTP114/api/leavedetails/appLeave/"+empId+"/"+response,leaveDetails)
    .map((res: Response) => res.text());
  }

  editLeaves(levId :number,leaveDetails : LeaveDetails ):Observable<string> {
    return this.http.post("http://localhost:8080/FTP114/api/leavedetails/editLeave/"+levId,leaveDetails)
    .map((res: Response) => res.text());
  }
}
