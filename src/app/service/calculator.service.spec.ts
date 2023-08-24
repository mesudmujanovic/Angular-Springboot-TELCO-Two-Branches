import { TestBed, flush } from '@angular/core/testing';

import { CalculatorService } from './calculator.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { priceCalculate } from '../Interface/interPrice';

fdescribe('CalculatorService', () => {
  let service: CalculatorService;
  let httpController: HttpTestingController

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[CalculatorService]
    });
    service = TestBed.inject(CalculatorService);
    httpController = TestBed.inject(HttpTestingController)
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should calculate price and discount', () =>{
  
    const expectedResponse: priceCalculate = {
      price: 100,
      discount: 20,
      calculatedPrice: 80 
    };

    const calulated: priceCalculate = {
      price: expectedResponse.price,
      discount: expectedResponse.discount,
      calculatedPrice: 80 
    }
    service.calculate( expectedResponse.price, expectedResponse.discount ).subscribe( calc =>{
      expect(calc).toEqual(calulated);
    });

    const request = httpController.expectOne('http://localhost:8080/api/calculate');
    expect(request.request.method).toBe('POST');
    request.flush(expectedResponse)
  });

  it('should return calculated price', ()=>{
    const mockRouter: number = 10;
    const mockTariff: number = 5;
    const calculatedPrice: number = 15;
    const calcPrice: priceCalculate = {
      price: mockRouter,
      discount: mockTariff,
      calculatedPrice: calculatedPrice
    }

    service.calculateRouterAndTariff(mockRouter, mockTariff).subscribe(calc =>{
      expect(calc).toEqual(calcPrice)
    });

    const request = httpController.expectOne(`http://localhost:8080/api/calculateAll`);
    expect(request.request.method).toBe('POST');
    request.flush(calcPrice);
  })
});
