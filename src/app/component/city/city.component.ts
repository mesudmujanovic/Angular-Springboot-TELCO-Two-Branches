import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { catchError, of, tap } from 'rxjs';
import { CityService } from 'src/app/service/city.service';
import { Address } from '../Interface/address-interface';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent {

cityForm: FormGroup;
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
  ).subscribe( e => console.log(e)
  );
}
}

}
