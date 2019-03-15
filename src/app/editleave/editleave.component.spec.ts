import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditleaveComponent } from './editleave.component';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {LeaveDetailsService} from '../leave-details.service';
import {EmployeeService} from '../employee.service';
import { RouterTestingModule } from '@angular/router/testing';


describe('EditleaveComponent', () => {
  let component: EditleaveComponent;
  let fixture: ComponentFixture<EditleaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      imports : [FormsModule,HttpModule,RouterTestingModule],
      declarations: [ EditleaveComponent ],
      providers : [LeaveDetailsService,EmployeeService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditleaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
