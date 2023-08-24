import { TestBed } from '@angular/core/testing';

import { LoginService } from './login.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { UserJWT } from '../Interface/UserJWT';

fdescribe('LoginService', () => {
  let service: LoginService;
  let httpTesging: HttpTestingController

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[LoginService]
    });
    service = TestBed.inject(LoginService);
    httpTesging = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  
  it('should return login user', () =>{
    const mockUser: UserJWT = 
     {
      id:1,
      username:"Mesud",
      password:"Mujanovic"
     }
    
     service.login(mockUser.username, mockUser.password).subscribe( user =>{
      expect(user).toEqual(mockUser);
     });

     const request = httpTesging.expectOne('http://localhost:8080/api/auth/login');
     expect(request.request.method).toBe('POST');
     request.flush(mockUser);
     httpTesging.verify();
  })
});
