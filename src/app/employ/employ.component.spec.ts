import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployComponent } from './employ.component';
import { EmployeeService } from '../employee.service';
import { HttpModule } from '@angular/http';
import { of } from 'rxjs/observable/of';
import { RouterTestingModule } from '@angular/router/testing';

const userServiceStub = {
  searchEmployee(empid) {
    console.log('came inside the stub');
    const emps = [
      {
      "empId":1000,
      "empFullName":"SANJANA KOLAGE",
      "empEmail":"SANJANAK@HEXAWARE.COM",
      "empMobileNo":"7768858666",
      "empDateOfJoining":"2016-05-20",
      "empDepartment":"HEXAVARSITY",
      "empMgrId":0,
      "empAvailLeavBal":26
      }
    ];
    return of( emps );
  }
};

describe('EmployComponent', () => {
  let component: EmployComponent;
  let employService : EmployeeService;
  
  let fixture: ComponentFixture<EmployComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpModule, RouterTestingModule
      ],
      declarations: [ EmployComponent ],
      providers: [{provide: EmployeeService, 
        useValue: userServiceStub}]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    employService = TestBed.get(EmployeeService);
    
    fixture = TestBed.createComponent(EmployComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    component.empno=1000;
    
  });

  xit(`the name employee Id to be '1000'`, async(()=>{
    const fixture = TestBed.createComponent(EmployComponent);
    const app = fixture.debugElement.componentInstance;
    spyOn(employService, 'searchEmployee').and.returnValue( of (userServiceStub));
    app.ngOnInit();
    alert(app.employ);
    console.log(app.employ);
    expect(app.employee.empId).toEqual(1000);
  }));

  it('should return a single user', () => {
    const userResponse =  {
      "empId":2000,
      "empFullName":"BHASKAR GURANA",
      "empEmail":"BHASKARG@HEXAWARE.COM",
      "empMobileNo":"8555001572",
      "empDateOfJoining":"2018-10-20",
      "empDepartment":"HEXAVARSITY",
      "empMgrId":1000,
      "empAvailLeavBal":8
    };
    let response;
    spyOn(employService, 'searchEmployee').and.returnValue( of (userResponse));

    employService.searchEmployee(2000).subscribe(res => {
      response = res;
    });

    expect(response).toEqual(userResponse);
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
