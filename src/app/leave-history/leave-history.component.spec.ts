import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import {FilterdataPipe } from '../filterdata.pipe';
import { LeaveHistoryComponent } from './leave-history.component';
import { LeaveDetailsService } from '../leave-details.service';
import { HttpModule } from '@angular/http';
import { EmployeeService } from '../employee.service';
import { RouterTestingModule } from '@angular/router/testing';
import {FormsModule} from '@angular/forms';
import { of } from 'rxjs/observable/of';


const leaveServiceStub = {
  searchLeaveHistory(empid) {
    console.log('came inside the stub');
    const emps = [
      { "levId":1,
      "levNoOfDays":2,
      "levStartDate":"2019-03-04",
      "levEndDate":"2019-03-05",
      "levType":"EL",
      "levStatus":"PENDING",
      "levReason":"sick",
      "levApplyDate":"2019-02-05",
      "levMgrComments":null,
      "empId":1000
    },
    {"levId":48,
    "levNoOfDays":1,
    "levStartDate":"2019-03-04",
    "levEndDate":"2019-03-05",
    "levType":"EL",
    "levStatus":"DENIED",
    "levReason":"sick",
    "levApplyDate":"2019-02-05",
    "levMgrComments":null,
    "empId":2000
  }
    ];
    return of( emps );
  }
};
describe('LeaveHistoryComponent', () => {
  let component: LeaveHistoryComponent;
  let fixture: ComponentFixture<LeaveHistoryComponent>;

  beforeEach(async(() => {
    localStorage.setItem("empId","1");
    TestBed.configureTestingModule({
      
      schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
      imports : [HttpModule, RouterTestingModule,FormsModule],
      declarations: [ LeaveHistoryComponent,FilterdataPipe ],
      // providers : [LeaveDetailsService,EmployeeService]
      providers: [{provide: LeaveDetailsService, 
        useValue: leaveServiceStub},EmployeeService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  it('should render one employee record', async(() => {
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.employees tr').length).toBe(3);
    });
  }));

  
  it(`the employee id to be '1000'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].empId).toEqual(1000);
  }));

   
  it(`the employee leave id to be '1'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].levId).toEqual(1);
  }));

  it(`the employee leaNumberOfDays id to be '2'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].levNoOfDays).toEqual(2);
  }));

  
  it(`the employee leaStartDate  to be '2019-03-04'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].levStartDate).toEqual("2019-03-04");
  }));

  it(`the employee leaEndDate to be '2019-03-05'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].levEndDate).toEqual("2019-03-05");
  }));

  it(`the employee leaLeaveType to be 'EL'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].levType).toEqual("EL");
  }));

  it(`the employee leaStatus to be 'PENDING'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].levStatus).toEqual("PENDING");
  }));

  it(`the employee leaReason to be 'sick'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].levReason).toEqual("sick");
  }));

  it(`the employee leaAppliedOn to be '2019-02-05'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].levApplyDate).toEqual("2019-02-05");
  }));

  it(`the employee leaManagerComment to be 'null'`, async(()=>{
    const fixture = TestBed.createComponent(LeaveHistoryComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lhistory[0].levMgrComments).toEqual(null);
  }));
  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
