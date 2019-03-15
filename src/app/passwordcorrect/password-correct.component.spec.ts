import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PasswordCorrectComponent } from './password-correct.component';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpModule } from '@angular/http';


describe('PasswordCorrectComponent', () => {
  let component: PasswordCorrectComponent;
  let fixture: ComponentFixture<PasswordCorrectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,HttpModule,RouterTestingModule
      ],
      declarations: [ PasswordCorrectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PasswordCorrectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
