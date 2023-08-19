import { TestBed } from '@angular/core/testing';
import { CartService } from './cart.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

fdescribe('CartService', () => {
  let service: CartService;
  let httpClientTesting: HttpTestingController

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers:[CartService]
    });
    service = TestBed.inject(CartService);
    httpClientTesting = TestBed.inject(HttpTestingController)
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch get tariff with tariffId', ()=>{
    const tariffId = 1;
    const expectedTariff = {
      id:1,
      name:"Tariff1",
      speed:"220mb/s",
      priceList:[]
    };

    service.adaTariffInCart(tariffId).subscribe( tariffs =>{
      expect(tariffs).toEqual(expectedTariff)
    });

    const req = httpClientTesting.expectOne(`http://localhost:8080/api/saveCartTariff/${tariffId}`);
    expect(req.request.method).toBe('GET');
    req.flush(expectedTariff);
  });

  it('it should get router with routerId', () =>{
    const routerId = 1;
    const mockRouter = {
      id: 1,
      description: "Router",
      price: 222
    };

    service.adaRouterInCart(routerId).subscribe( router =>{
      expect(router).toEqual(mockRouter)
    }
    );

    const request = httpClientTesting.expectOne(`http://localhost:8080/api/saveCartRouter/${routerId}`);
    expect(request.request.method).toBe('GET');
    request.flush(mockRouter);
  })
});
