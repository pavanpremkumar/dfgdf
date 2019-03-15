import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeComponent } from './employee.component';
import { FormsModule } from '@angular/forms';
// import { of } from 'rxjs';
import { of } from 'rxjs/observable/of';
import { FilterdataPipe } from '../filterdata.pipe';
import { HttpModule } from '@angular/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { EmployeeService } from '../employee.service';
import { RouterTestingModule } from '@angular/router/testing';

const userServiceStub = {
  getEmployees() {
    console.log('came inside the stub');
    const emps = [
      {
        "empId":1000,
        "empName":"SAHIL MATLANI",
        "empEmail":"SAHIL@GMAIL.COM",
        "empMob":"7028365639",
        "empJoinDate":"2018-12-20",
        "empAvlLeaveBal":0,
        "empDept":"HEXAVARSITY",
        "empMgrId":0
      
      },
      {"empId":2000,
      "empName":"KALPANA K",
      "empEmail":"KALPANA@GMAIL.COM",
      "empMob":"9587456125",
      "empJoinDate":"2017-10-15",
      "empAvlLeaveBal":10,
      "empDept":"INNOVATION",
      "empMgrId":1000
    }
    ];
    return of( emps );
  }
};

describe('EmployeeComponent', () => {
  let component: EmployeeComponent;
  let fixture: ComponentFixture<EmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,HttpModule,RouterTestingModule,HttpClientTestingModule
      ],
      declarations: [ EmployeeComponent,FilterdataPipe ], 
      providers: [{provide: EmployeeService, 
        useValue: userServiceStub}]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  
  it(`the name employee Id to be '1000'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empId).toEqual(1000);
  }));

  it(`the name employee to be 'SAHIL MATLANI'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empName).toEqual('SAHIL MATLANI');
  }));

  it(`the Email employee to be 'SAHIL@GMAIL.COM'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empEmail).toEqual('SAHIL@GMAIL.COM');
  }));

  it(`the MobileNo employee to be '7768858666'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empMob).toEqual('7028365639');
  }));

  it(`the DateOfJoining employee to be '2018-12-20'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empJoinDate).toEqual('2018-12-20');
  }));

  it(`the Department employee to be 'HEXAVARSITY'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empDept).toEqual('HEXAVARSITY');
  }));

  it(`the ManagerId employee to be '0'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empMgrId).toEqual(0);
  }));

  
  it(`the Available Leave Bal employee to be '26'`, async(()=>{
    const fixture = TestBed.createComponent(EmployeeComponent);
    const app = fixture.debugElement.componentInstance;
    app.ngOnInit();
    expect(app.employees[0].empAvlLeaveBal).toEqual(0);
  }));

  
  it('should render one employee record', async(() => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.employees tr').length).toBe(2);
    });
  }));

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
