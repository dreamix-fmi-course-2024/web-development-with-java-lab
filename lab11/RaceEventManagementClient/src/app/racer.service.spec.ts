import { TestBed } from '@angular/core/testing';

import { RacerService } from './racer.service';

describe('RacerService', () => {
  let service: RacerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RacerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
