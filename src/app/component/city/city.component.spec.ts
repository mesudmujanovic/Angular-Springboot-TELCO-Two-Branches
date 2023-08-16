import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CityComponent } from './city.component';
import { CityService } from 'src/app/service/city.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { City } from 'src/app/Interface/city-interface';
import { of } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { LocalStorageService } from 'src/app/service/local-storage.service';
import { RouterTestingModule } from '@angular/router/testing';
import { Router } from '@angular/router';

fdescribe('CityComponent', () => {
  let component: CityComponent;
  let fixture: ComponentFixture<CityComponent>;
  let cityService: CityService;
  let router: Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CityComponent],
      imports: [
        HttpClientTestingModule,
        FormsModule,
        RouterTestingModule
      ],
      providers: [CityService, LocalStorageService]
    })
      .compileComponents();

    fixture = TestBed.createComponent(CityComponent);
    component = fixture.componentInstance;
    cityService = TestBed.inject(CityService);
    router = TestBed.inject(Router);
    fixture.detectChanges();
  });


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should fecth all citys data', () => {
    const mockCityData: City[] = [
      { id: 1, name: "Novi Pazar", addressDtoList: [] },
      { id: 2, name: "Sjenica", addressDtoList: [] }
    ];
    spyOn(cityService, 'getAllCityes').and.returnValue(of(mockCityData));
    fixture.detectChanges();
    component.allCitys();
    expect(component.allCitys).toBeDefined();
    component.allCitys().subscribe(
      data => {
        expect(data).toEqual(mockCityData)
      }
    )
  })

  it('should set onSelectedAddressFiled to true when a city is selected', () => {
    component.selectedCity = { id: 1, name: 'Test City', addressDtoList: [] };
    component.onCityChange();
    expect(component.onSelectedAddressFiled).toBe(true);
  })

  it('should not selectedCity', () => {
    component.selectedCity = null;
    component.onCityChange();
    expect(component.selectedAddress).toBe(null);
    expect(component.onSelectedAddressFiled).toBe(false);
  })

  it('should is selected selectedAddress', () => {
    component.selectedAddress = { id: 1, name: "Igmanska", numberDtoList: [] };
    component.onAddressChange();
    expect(component.onSelectedNumberFiled).toBe(true);
  })

  it('should is not selected selectedAddress', () => {
    component.selectedAddress = null;
    component.onAddressChange();
    expect(component.selectedAddress).toBe(null);
    expect(component.onSelectedAddressFiled).toBe(false);
  });

  it('Should navigate to main-page when all required values selected', () => {
    component.selectedCity = { id: 1, name: 'Selected City', addressDtoList: [] };
    component.selectedAddress = { id: 1, name: "Selected address", numberDtoList: [] };
    component.selectedNumber = { id: 1, num: "Selected num" };
    spyOn(router, 'navigate');
    component.proveriDostupnost();    
    expect(router.navigate).toHaveBeenCalledWith(['main-page'])
  });

});