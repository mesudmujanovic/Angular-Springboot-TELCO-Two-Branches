import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { City } from '../Interface/city-interface';
import { BASE_URL } from '../const/backend-url';
import { LocalStorageService } from './local-storage.service';
import { Address } from '../Interface/address-interface';
import { Number } from '../Interface/number-interface';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private http: HttpClient,
    private localStorage: LocalStorageService,
    private router: Router) { }

  addCity(name: string): Observable<City> {
    const city: City = {
      id: 0,
      name: name,
      addressDtoList:[]
    };    
    return this.http.post<City>(`${BASE_URL}/saveCity`, city);
  }

  getAllCityes(): Observable<City[]>{
   return this.http.get<City[]>(`${BASE_URL}/getAllCity`);
  }

  proveriDostupnost(selectedCity: City, selectedAddress: Address, selectedNumber: Number) {
    if (selectedCity && selectedAddress && selectedNumber) {
      const cityAddressNumber = {
        city: selectedCity.name,
        addressDtoList: selectedAddress.name,
        number: selectedNumber.num
      };
      this.localStorage.setLocalStorage('cityAddressNumber', cityAddressNumber);
      const savelcs = this.localStorage.getLocalStorage('cityAddressNumber');
      this.router.navigate(['main-page']);
    }
  }

 
  
}
