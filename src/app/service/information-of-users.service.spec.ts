import { TestBed } from '@angular/core/testing';

import { InformationOfUsersService } from './information-of-users.service';

describe('InformationOfUsersService', () => {
  let service: InformationOfUsersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InformationOfUsersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
