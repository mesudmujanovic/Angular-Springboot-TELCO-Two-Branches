import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { priceCalculate } from '../Interface/interPrice';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  constructor( private http: HttpClient ) { }

  calculate( price: number, discount: number){
    const request = { price, discount }    
    return this.http.post<priceCalculate>(`http://localhost:8080/api/calculate`,request)
  }

  calculateRouterAndTariff( price: number, discount: number){
    const request = { price, discount }
    console.log("sabiranje",request);
    return this.http.post<priceCalculate>(`http://localhost:8080/api/calculateAll`,request)
  }

}