import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TariffsForMainPageComponent } from './tariffs-for-main-page.component';

describe('TariffsForMainPageComponent', () => {
  let component: TariffsForMainPageComponent;
  let fixture: ComponentFixture<TariffsForMainPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TariffsForMainPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TariffsForMainPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
