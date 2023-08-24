import { TestBed } from '@angular/core/testing';

import { SignUpService } from './sign-up.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { UserJWT } from '../Interface/UserJWT';

fdescribe('SignUpService', () => {
  let service: SignUpService;
  let httpTest: HttpTestingController

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[SignUpService]
    });
    service = TestBed.inject(SignUpService);
    httpTest =  TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return users', () =>{
    const mockUser: UserJWT= {
      id: 1,
    username: "mesud",
    password: "mesud123"
    }

    service.signUp(mockUser.username, mockUser.password).subscribe( user =>{
     expect(user).toEqual(mockUser);
    });
    const request = httpTest.expectOne('http://localhost:8080/api/auth/signup');
    expect(request.request.method).toBe('POST');
    request.flush(mockUser);
    httpTest.verify();
  })
});
