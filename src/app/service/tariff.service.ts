import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ITariff } from '../Interface/ITariff';
import { BASE_URL } from '../const/backend-url';

@Injectable({
  providedIn: 'root'
})
export class TariffService {

  constructor(private http: HttpClient) { }

getAllTariffs(): Observable<ITariff[]>{
  return this.http.get<ITariff[]>(`${BASE_URL}/getAllTariffs`)
}
}
