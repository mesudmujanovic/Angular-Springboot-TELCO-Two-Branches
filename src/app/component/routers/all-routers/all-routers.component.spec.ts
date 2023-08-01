import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllRoutersComponent } from './all-routers.component';

describe('AllRoutersComponent', () => {
  let component: AllRoutersComponent;
  let fixture: ComponentFixture<AllRoutersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllRoutersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllRoutersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
