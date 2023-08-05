import { Component } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { ITariff } from 'src/app/Interface/ITariff';
import { CalculatorService } from 'src/app/service/calculator.service';
import { TariffService } from 'src/app/service/tariff.service';

@Component({
  selector: 'app-tariffs',
  templateUrl: './tariffs.component.html',
  styleUrls: ['./tariffs.component.css']
})
export class TariffsComponent {

  tariffs: Observable<ITariff[]>;

  currentIndex = 0;
  selectedPrice: any
  selectedTarifIndex: number = -1;
  details: boolean = false;
  price: number;
  discount: number;
  calculatedPrice: number;

  constructor( private tariffService: TariffService ){}


  
   allTariffs(){
    return this.tariffs = this.tariffService.getAllTariffs().pipe(
      tap( response => {
        console.log("res",response);
      })
    )
  }

  ngOnInit(): void {
    this.allTariffs();
  }

  prevSlide() {
    if (this.currentIndex > 0) {
      this.currentIndex--;
    }
  }
  nextSlide() {
    this.tariffs.subscribe( (tariff: ITariff[]) => {
      if (this.currentIndex < tariff.length - 3) {
        this.currentIndex++;
      }
    } )
    }

  isActive(index: number): boolean {
    return index === this.currentIndex +1;
  }

}

