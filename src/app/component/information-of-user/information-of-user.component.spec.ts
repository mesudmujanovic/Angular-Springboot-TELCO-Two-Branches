import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InformationOfUserComponent } from './information-of-user.component';

describe('InformationOfUserComponent', () => {
  let component: InformationOfUserComponent;
  let fixture: ComponentFixture<InformationOfUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InformationOfUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InformationOfUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
