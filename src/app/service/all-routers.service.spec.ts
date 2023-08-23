import { TestBed } from '@angular/core/testing';

import { AllRoutersService } from './all-routers.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TariffService } from './tariff.service';
import { IRouters } from '../Interface/iRouters';

fdescribe('AllRoutersService', () => {
  let service: AllRoutersService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [TariffService]
    });
    service = TestBed.inject(AllRoutersService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('sgould fetch addRouters', () => {
    const mockRouters: IRouters[] = [
      {
        id: 1,
        description: 'opis',
        price: 222
      },
      {
        id: 2,
        description: 'opis2',
        price: 333
      }
    ]
    service.getAllRouters().subscribe( routers =>{
      expect(routers).toEqual(mockRouters)
    });

   const req = httpTestingController.expectOne('http://localhost:8080/api/getAllRouters');
   expect(req.request.method).toBe('GET');
   req.flush(mockRouters)
  });

  it('should send a Post request to Add router', ()=>{
    const mockRouter: IRouters = {id: 1, description: 'opis', price: 222}
    
    service.addRouters(mockRouter.description, mockRouter.price).subscribe(  router =>{
      expect(router).toEqual(mockRouter)
    })

    const req = httpTestingController.expectOne('http://localhost:8080/api/addRouter');
    expect(req.request.method).toBe('POST');
    expect(req.request.body).toEqual({ description:'opis', price:222 })
    req.flush(mockRouter);
  })
});
