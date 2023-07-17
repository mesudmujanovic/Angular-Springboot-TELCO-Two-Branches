import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, catchError, of, tap } from 'rxjs';
import { CityService } from 'src/app/service/city.service';
import { City } from '../Interface/city-interface';
import { Address } from '../Interface/address-interface';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent {

cityForm: FormGroup;
cityes: Observable<City[]>
selectedCity: City| null;
selectedAddress: Address | null

constructor(private cityService: CityService,
  private formBuilder: FormBuilder){
  this.cityForm = this.formBuilder.group({
    name: [ '', Validators.required ]
  })
}

onAddCity(){
if( this.cityForm.valid ){
  const name = this.cityForm.get('name').value;
  this.cityService.addCity(name).pipe(
    tap( response =>{
      console.log("response",response);
      
    }),
    catchError( error =>{
      return of([]);
    })
  ).subscribe()
}
}

allCitys(): Observable<City[]>{
  return  this.cityService.getAllCityes().pipe(
    tap( response =>{

    }),
    catchError( error =>{
      return of([]);
    })
  )
}

onCityChange(){
  
  if( this.selectedCity ){
    console.log("ngValue:", this.selectedCity);
  console.log("ngModel:", this.selectedCity)
    const filter = this.selectedCity.addressDtoList;
    this.selectedAddress = filter.length > 0 ? filter[0] : null; 
  }else{
    this.selectedAddress = null;
  }
}

ngOnInit(): void{
 this.cityes = this.allCitys();
 this.cityes.subscribe()
  
}

}
