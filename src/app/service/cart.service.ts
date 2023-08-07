import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BASE_URL } from '../const/backend-url';
import { Observable } from 'rxjs';
import { IRouters } from '../Interface/iRouters';

@Injectable({
  providedIn: 'root'
})

export class CartService {

  constructor( private http: HttpClient ) { }

  adaTariffInCart( tariffId: number ): Observable<any>  {
   return this.http.get(`${BASE_URL}/saveCartTariff/${tariffId}`)   
  }

  adaRouterInCart( routerId: number ):Observable<IRouters>{
    return this.http.get<IRouters>(`${BASE_URL}/saveCartRouter/${routerId}`)
  }
}
