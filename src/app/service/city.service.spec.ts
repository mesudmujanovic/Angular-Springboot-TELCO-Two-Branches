import { TestBed } from '@angular/core/testing';
import { CityService } from './city.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { City } from '../Interface/city-interface';


fdescribe('CityService', () => {
  let service: CityService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
    imports: [HttpClientTestingModule],
    providers: [CityService]
    });
    service = TestBed.inject(CityService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });
      
  afterEach(() => {
    httpTestingController.verify();
  })

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch all verify data', () =>{
    const mockVerifyData: City[] = [
      { id: 1, name: "Mesud", addressDtoList:[]},
      { id: 2, name: "Nadi", addressDtoList:[]}
    ];
    service.getAllCityes().subscribe( data => {
      expect(data).toEqual(mockVerifyData);
    })
    const req = httpTestingController.expectOne('http://localhost:8080/api/getAllCity');
    expect(req.request.method).toBe('GET');
    req.flush(mockVerifyData);
  });

});
