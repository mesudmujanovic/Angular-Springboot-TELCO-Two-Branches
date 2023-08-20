import { TestBed } from '@angular/core/testing';

import { InformationOfUsersService } from './information-of-users.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CartService } from './cart.service';
import { IinfoUsers } from '../Interface/IinfoUsers';

fdescribe('InformationOfUsersService', () => {
  let service: InformationOfUsersService;
  let httpTesting: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[CartService]
    });
    service = TestBed.inject(InformationOfUsersService);
    httpTesting = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return infoUsersGetById', ()=>{
     
    const userInfoId: number = 1;

    const mockInfoUser: IinfoUsers = {
      id: 1,
      name: "Mesud",
      lastName: "Mujanovic",
      email: "mesud9494@gmail.com",
      phone:"+381669659666"
    };

    service.getById(userInfoId).subscribe( info =>{
      expect(info).toEqual(mockInfoUser);
    })

    const checkRequest = httpTesting.expectOne(`http://localhost:8080/api/getById/${userInfoId}`);
    expect(checkRequest.request.method).toBe('GET');
    checkRequest.flush(mockInfoUser);
  })
});
