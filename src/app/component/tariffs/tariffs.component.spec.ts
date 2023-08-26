import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TariffsComponent } from './tariffs.component';
import { TariffService } from 'src/app/service/tariff.service';
import { ITariff } from 'src/app/Interface/ITariff';
import { of } from 'rxjs';
import { HttpClientTestingModule } from '@angular/common/http/testing';

fdescribe('TariffsComponent', () => {
  let component: TariffsComponent;
  let fixture: ComponentFixture<TariffsComponent>;
  let tariffService: TariffService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TariffsComponent],
      imports: [HttpClientTestingModule],
      providers: [TariffService],
    })
      .compileComponents();

    fixture = TestBed.createComponent(TariffsComponent);
    component = fixture.componentInstance;
    tariffService = TestBed.inject(TariffService)
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should return allTariffs', () => {
    const tariffMockData: ITariff[] = [
      {
        id: 1, name: "Tariff500", speed: "220mb", priceList: [
          { id: 1, price: "500$", contractDuration: 12, oneTime: false, name: "tariff", discount: 1 }]
      }
    ];
    spyOn(tariffService, "getAllTariffs").and.returnValue(of(tariffMockData));
    component.allTariffs();
    expect(component.allTariffs).toBeDefined();
    component.allTariffs().subscribe(tariffs => {
      expect(tariffs).toEqual(tariffMockData);
    })
  })

  it('should display content when tariffs are available', () => {
    const tariffs: ITariff[] = [{
      id: 1, name: 'Tariff 1', speed: '50 Mbit/s',
      priceList: [{
        id: 1, price: "222", contractDuration: 12, oneTime: false, name: "adsl300", discount: 10
      }]
    }];

    component.tariffs = of(tariffs);
    fixture.detectChanges();
    const mainContainer = fixture.nativeElement.querySelector('.slide');
    expect(mainContainer).toBeTruthy();
  })
});
