import { TestBed } from '@angular/core/testing';

import { AllRoutersService } from './all-routers.service';

describe('AllRoutersService', () => {
  let service: AllRoutersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllRoutersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
