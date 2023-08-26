import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';

import { NavbarComponent } from './navbar.component';

fdescribe('NavbarComponent', () => {
  let component: NavbarComponent;
  let fixture: ComponentFixture<NavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should shopPopUp when click the mouseLeave', fakeAsync(() =>{
   component.showPopUp = false;
   component.popUp();
   tick(500);
   expect(component.showPopUp).toBe(true)
  }))

  it('should set shopPopUp to false on mouseLeave', () =>{
    component.showPopUp = true;
    component.hidePopUp1();
    expect(component.showPopUp1).toBe(false);
  })

  it('should showPopUp1 when click on the hidePopUp1', fakeAsync(()=>{
    component.showPopUp1 = false;
    component.popUp1();
    tick(500);
    expect(component.showPopUp1).toBe(true);
  }))

  it('should click in the hidePopUp1 to close', () =>{
    component.showPopUp1 = true;
    component.hidePopUp1();
    expect(component.showPopUp1).toBe(false);
  })
});
