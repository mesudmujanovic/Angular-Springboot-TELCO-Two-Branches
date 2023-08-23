import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TariffService } from './tariff.service';
import { ITariff } from '../Interface/ITariff';
import { IRouters } from '../Interface/iRouters';

fdescribe('TariffService', () => {
  let service: TariffService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[ HttpClientTestingModule ],
      providers:[TariffService]
    });
    service = TestBed.inject(TariffService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() =>{
    httpTestingController.verify();
  })

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('Should fetch all tariff data', () =>{
    const tariffMockData: ITariff[] = [
      { id: 1, name:"Tariff500", speed:"220mb", priceList:[
        { id:1, price:"500$", contractDuration: 12, oneTime: false, name:"tariff", discount: 1 }]
      },
      { id: 2, name:"Tariff100", speed:"120mb", priceList:[
        { id:2, price:"300$", contractDuration: 0, oneTime: true, name:"tariff", discount: 20 }]
      }
    ]
    
    service.getAllTariffs().subscribe( data => {
      expect(data).toEqual(tariffMockData);
    });
    
    const req = httpTestingController.expectOne('http://localhost:8080/api/getAllTariffs');
    expect(req.request.method).toBe('GET');
    req.flush(tariffMockData);
  });

});
