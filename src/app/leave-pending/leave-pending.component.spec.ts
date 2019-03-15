import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs/observable/of';

import { LeavePendingComponent } from './leave-pending.component';
import { SortdataPipe } from '../sortdata.pipe';
import { HttpModule } from '@angular/http';
import { LeaveDetailsService } from '../leave-details.service';
import { EmployeeService } from '../employee.service';
import { RouterTestingModule } from '@angular/router/testing';
const leaveServiceStub = {
  getPendingLeaves(empid) {
    console.log('came inside the stub');
    const emps = [
      {"levId":45,
      "levNoOfDays":2,
      "levStartDate":"2019-03-04",
      "levEndDate":"2019-03-05",
      "levType":"EL",
      "levStatus":"PENDING",
      "levReason":"hkyu",
      "levApplyDate":"2019-03-05",
      "levMgrComments":null,
      "empId":1000
    },
    {"levId":46,
    "levNoOfDays":2,
    "levStartDate":"2019-04-04",
    "levEndDate":"2019-03-05",
    "levType":"EL",
    "levStatus":"PENDING",
    "levReason":"hkyu",
    "levApplyDate":"2019-03-05",
    "levMgrComments":null,
    "empId":1000
  }

    ];
    return of( emps );
  }
};
describe('LeavePendingComponent', () => {
  let component: LeavePendingComponent;
  let fixture: ComponentFixture<LeavePendingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpModule,RouterTestingModule
      ],
      declarations: [ LeavePendingComponent ,SortdataPipe],
      // providers: [LeaveDetailsService, EmployeeService]
      providers: [{provide: LeaveDetailsService, 
        useValue: leaveServiceStub},EmployeeService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeavePendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  it(`the employee id to be '1000'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].empId).toEqual(1000);
  }));

  it(`the employee leave id to be '45'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].levId).toEqual(45);
  }));

  it(`the employee leaNumberOfDays id to be '2'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].levNoOfDays).toEqual(2);
  }));

  
  it(`the employee leaStartDate  to be '2019-03-04'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].levStartDate).toEqual("2019-03-04");
  }));

  it(`the employee leaEndDate to be '2019-03-05'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].levEndDate).toEqual("2019-03-05");
  }));

  it(`the employee leaLeaveType to be 'EL'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].levType).toEqual("EL");
  }));

  it(`the employee leaStatus to be 'PENDING'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].levStatus).toEqual("PENDING");
  }));

  it(`the employee leaReason to be 'sick'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].levReason).toEqual("hkyu");
  }));

  it(`the employee leaAppliedOn to be '2019-03-05'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].levApplyDate).toEqual("2019-03-05");
  }));

  it(`the employee leaManagerComment to be 'null'`, async(()=>{
    const fixture = TestBed.createComponent(LeavePendingComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.lpending[0].levMgrComments).toEqual(null);
  }));

  
  it('should render one employee record', async(() => {
    const fixture = TestBed.createComponent(LeavePendingComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.leave tr').length).toBe(11);
    });
  }));

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
