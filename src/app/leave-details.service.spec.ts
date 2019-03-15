import { TestBed, inject } from '@angular/core/testing';
import { HttpModule } from '@angular/http';
import { LeaveDetailsService } from './leave-details.service';

describe('LeaveDetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({ 
      imports : [HttpModule],
      providers: [LeaveDetailsService]
    });
  });

  it('should be created', inject([LeaveDetailsService], (service: LeaveDetailsService) => {
    expect(service).toBeTruthy();
  }));
});
