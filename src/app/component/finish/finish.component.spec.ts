import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinishComponent } from './finish.component';
import { InformationOfUsersService } from 'src/app/service/information-of-users.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { IinfoUsers } from 'src/app/Interface/IinfoUsers';
import { Observable, of } from 'rxjs';

fdescribe('FinishComponent', () => {
  let component: FinishComponent;
  let fixture: ComponentFixture<FinishComponent>;
  let infoUsersService: InformationOfUsersService

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FinishComponent],
      imports: [HttpClientTestingModule],
      providers: [InformationOfUsersService]
    })
      .compileComponents();

    fixture = TestBed.createComponent(FinishComponent);
    component = fixture.componentInstance;
    infoUsersService = TestBed.inject(InformationOfUsersService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should return users getById', () => {

    const userInfo: IinfoUsers = {
      id: 1, name: "user", lastName: "users", email: "user@gmail.com", phone: "123444444"
    };

    spyOn(infoUsersService, 'getById').and.returnValue(of(userInfo));

    const userFunction = component.getUserInfo();

    expect(userFunction instanceof Observable).toBeTruthy();

    let result: any;
    userFunction.subscribe((userInfo) => {
      result = userInfo;
    });

    expect(result).toEqual(userInfo);
  })

  it('should displat user info', () => {

    const userInfo: IinfoUsers = { id: 1, name: "user", lastName: "users", email: "user@gmail.com", phone: "123444444" }
    component.showUserInfo = of(userInfo);
    fixture.detectChanges();

    const element = fixture.nativeElement;
    const lastName = element.querySelector('h4').textContent;
    expect(lastName).toContain('users');
  })

  it('should show users on html element', () => {
    const mockUsers: IinfoUsers = {
      id: 1, name: "user", lastName: "users", email: "user@gmail.com", phone: "123444444"
    };
    component.showUserInfo = of(mockUsers);
    fixture.detectChanges();
    const el = fixture.nativeElement;
    const name = el.querySelector('h4').textContent;
    const email = el.querySelector('h4').textContent;
    expect(email).toContain('user@gmail.com');
    expect(name).toContain('user')
  })

  it('should show user info into html', () =>{
    const mockUsers: IinfoUsers = {
      id: 1, name: "user", lastName: "users", email: "user@gmail.com", phone: "123444444"
    };

    component.showUserInfo = of(mockUsers);
    fixture.detectChanges();
    const el = fixture.nativeElement;
    const phone = el.querySelector('h4').textContent;
    expect(phone).toContain('123444444');
  })

});
