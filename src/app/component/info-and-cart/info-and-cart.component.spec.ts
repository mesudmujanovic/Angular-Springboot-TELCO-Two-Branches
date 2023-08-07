import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoAndCartComponent } from './info-and-cart.component';

describe('InfoAndCartComponent', () => {
  let component: InfoAndCartComponent;
  let fixture: ComponentFixture<InfoAndCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoAndCartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoAndCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
