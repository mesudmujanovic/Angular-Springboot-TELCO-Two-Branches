import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CityComponent } from './city.component';
import { CityService } from 'src/app/service/city.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { City } from 'src/app/Interface/city-interface';
import { of } from 'rxjs';
import { StoreModule } from '@ngrx/store';
import { appReducers } from 'src/app/ngrx-store/reducers/app.reducers';

describe('CityComponent', () => {
  let component: CityComponent;
  let fixture: ComponentFixture<CityComponent>;
  let cityService: CityService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CityComponent ],
      imports: [
        HttpClientTestingModule,
      ],
      providers:[CityService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CityComponent);
    component = fixture.componentInstance;
    cityService = TestBed.inject(CityService)
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should fecth all citys data', () =>{
    const mockCityData: City[] = [
      {id:1, name:"Novi Pazar", addressDtoList:[]},
      {id:2, name:"Sjenica", addressDtoList:[]}
    ];
    spyOn(cityService,'getAllCityes').and.returnValue(of(mockCityData));
    fixture.detectChanges();
    component.allCitys();
    expect(component.allCitys).toBeDefined();
    component.allCitys().subscribe(
      data => {
        expect(data).toEqual(mockCityData)
      }
    )
  })

});
