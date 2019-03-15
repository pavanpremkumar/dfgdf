import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { LoginComponent } from './login/login.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployComponent } from './employ/employ.component';
import { ManagerComponent } from './manager/manager.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LeaveHistoryComponent } from './leave-history/leave-history.component';
import { LeavePendingComponent } from './leave-pending/leave-pending.component';
import { ApproveDenyComponent } from './approve-deny/approve-deny.component';
import { ApplyLeaveComponent } from './apply-leave/apply-leave.component';
import {RouterModule,Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {FilterdataPipe } from './filterdata.pipe';
import { SortdataPipe} from './sortdata.pipe';
import { LeaveDetailsService} from './leave-details.service';



import { AppComponent } from './app.component';
import { PasswordCorrectComponent } from './passwordcorrect/password-correct.component';
import { EditleaveComponent } from './editleave/editleave.component';
import { HomeComponent } from './home/home.component';
const data:Routes = [
  {path:'',component:HomeComponent},
  {path:'emp',component:EmployeeComponent},
{path:'login',component:LoginComponent},
{path:'appDen',component:ApproveDenyComponent},
{path:'DashBoard',component:DashboardComponent},
{path:'applyLeave',component:ApplyLeaveComponent},
{path:'pending',component:LeavePendingComponent},
{path:'history',component:LeaveHistoryComponent},
{path:'pswdC',component:PasswordCorrectComponent},
{path:'editleave',component:EditleaveComponent}


];
@NgModule({
  declarations: [
    AppComponent,LoginComponent,
    EmployeeComponent,
    EmployComponent,
    ManagerComponent,
    DashboardComponent,
    LeaveHistoryComponent,
    LeavePendingComponent,
    ApproveDenyComponent,
    ApplyLeaveComponent,
    FilterdataPipe ,
    SortdataPipe,
    PasswordCorrectComponent,
    EditleaveComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,HttpModule,
    FormsModule,
    RouterModule.forRoot(data)
  ],
  providers: [LeaveDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
