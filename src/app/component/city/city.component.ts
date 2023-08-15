import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, catchError, of, tap } from 'rxjs';
import { CityService } from 'src/app/service/city.service';
import { City } from '../../Interface/city-interface';
import { Address } from '../../Interface/address-interface';
import { Number } from '../../Interface/number-interface';
import { Router } from '@angular/router';
import { LocalStorageService } from 'src/app/service/local-storage.service';
@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent {

  cityForm: FormGroup;
  cityes: Observable<City[]>
  selectedCity: City | null;
  selectedAddress: Address | null
  selectedNumber: Number | null;
  onSelectedCityFiled: boolean = false;
  onSelectedAddressFiled: boolean = false;
  onSelectedNumberFiled: boolean = false;

  constructor(private cityService: CityService,
    private formBuilder: FormBuilder,
    private router: Router,
    private localStorage: LocalStorageService) {
    this.cityForm = this.formBuilder.group({
      name: ['', Validators.required]
    });
  }

  onAddCity() {
    if (this.cityForm.valid) {
      const name = this.cityForm.get('name').value;
      this.cityService.addCity(name).pipe(
        tap(response => {
          console.log("response", response);
        }),
        catchError(error => {
          return of([]);
        })
      ).subscribe()
    }
  }

  allCitys(): Observable<City[]> {
    return this.cityService.getAllCityes().pipe(
      tap(response => {
        console.log("res",response);
      }),
      catchError(error => {
        return of([]);
      })
    )
  }

  onCityChange() {
    if (this.selectedCity) {
      this.onSelectedAddressFiled = true;
      // const filter = this.selectedCity.addressDtoList;
      // this.selectedAddress = filter.length > 0 ? filter[this.selectedCity.id] : null;
    } else {
      this.selectedAddress = null;
    }
  }

  onAddressChange() {
    if (this.selectedAddress) {
      this.onSelectedNumberFiled = true
    } else {
      this.selectedNumber = null;
    }
  }

  onNumberChange() {
    if (this.selectedNumber) {
      console.log(this.selectedNumber);
    }
  }

  proveriDostupnost() {
    if (this.selectedCity &&
      this.selectedAddress &&
      this.selectedNumber) {
      const cityAddressNumber = {
       city:  this.selectedCity.name,
       addressDtoList:  this.selectedAddress.name,
       number:  this.selectedNumber.num,
      }      
      this.localStorage.setLocalStorage('cityAddressNumber',cityAddressNumber)
      const savelcs = this.localStorage.getLocalStorage('cityAddressNumber');
      this.cityService.saveCity(savelcs);
      this.router.navigate(['main-page'])
    }
  }

  ngOnInit(): void {
    this.cityes = this.allCitys();
    this.cityes.subscribe()
  }

}
