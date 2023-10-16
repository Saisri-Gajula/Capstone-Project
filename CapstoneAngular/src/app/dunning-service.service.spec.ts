import { TestBed } from '@angular/core/testing';

import { DunningServiceService } from './dunning-service.service';

describe('DunningServiceService', () => {
  let service: DunningServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DunningServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
