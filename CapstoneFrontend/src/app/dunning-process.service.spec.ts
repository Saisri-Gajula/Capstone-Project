import { TestBed } from '@angular/core/testing';

import { DunningProcessService } from './dunning-process.service';

describe('DunningProcessService', () => {
  let service: DunningProcessService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DunningProcessService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
