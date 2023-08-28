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
  onSelectedAddressFiled: boolean = false;
  onSelectedNumberFiled: boolean = false;
  component: { id: number; name: string; addressDtoList: any[]; }[];

  constructor(private cityService: CityService,
    private formBuilder: FormBuilder,
    private router: Router,
    private localStorage: LocalStorageService) {
      
    this.cityForm = this.formBuilder.group({
      name: ['', Validators.required]
    });
  }

  onCityChange() {
    if (this.selectedCity) {
      this.onSelectedAddressFiled = true;
          // const filter = this.selectedCity.addressDtoList;
      // this.selectedAddress = filter.length > 0 ? filter[this.selectedCity.id] : null;
    } else {
      this.onSelectedAddressFiled = false;
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

  onNumberChange() {
    if (this.selectedNumber) {
    }
  }

  proveriDostupnost(){
    this.cityService.proveriDostupnost(this.selectedCity, this.selectedAddress, this.selectedNumber)
  }

  ngOnInit(): void {
    this.cityes = this.cityService.getAllCityes();
    this.cityes.subscribe();
  }

}
