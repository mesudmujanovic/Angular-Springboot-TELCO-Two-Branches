import { Component } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { ITariff } from 'src/app/Interface/ITariff';
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

calculatePriceBackend() {
  this.tariffService.calculate(this.price, this.discount).pipe(    
    tap( response =>{
    this.calculatedPrice = response.calculatedPrice;     
    })
  ).subscribe();
}

  showPriceList(tarifIndex: number, priceIndex: number) {
    this.tariffs.subscribe(tariffs => {
      const selectedTarif = tariffs[tarifIndex]; // Odabir tarife na koju ste kliknuli
      this.selectedPrice = selectedTarif.priceList[priceIndex]; // Odabir cijene iz odabrane tarife
      this.selectedTarifIndex = tarifIndex; // Postavljanje indeksa odabrane tarife
      this.price = this.selectedPrice.price;
      this.discount = this.selectedPrice.discount;
    });
  }
  
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

  detailsClick(){
    this.calculatePriceBackend();
    this.details = true;
    this.selectedPrice; 
  }

  closeDetails(){
    this.details = false;
  }


}

