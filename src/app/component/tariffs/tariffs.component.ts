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

  divs = [
    { title: 'Div 1', content: 'Sadržaj za div 1', price:'222$' },
    { title: 'Div 2', content: 'Sadržaj za div 2', price:'12$' },
    { title: 'Div 3', content: 'Sadržaj za div 3', price:'22$' },
    { title: 'Div 4', content: 'Sadržaj za div 4', price:'122$' },
    { title: 'Div 5', content: 'Sadržaj za div 5', price:'41$' },
    { title: 'Div 6', content: 'Sadržaj za div 6', price:'90$' },
  ];
  currentIndex = 0;

  selectedPrice: any
  selectedTarifIndex: number = -1;

  constructor( private tariffService: TariffService ){}


  showPriceList(tarifIndex: number, priceIndex: number) {
    this.tariffs.subscribe(tariffs => {
      const selectedTarif = tariffs[tarifIndex]; // Odabir tarife na koju ste kliknuli
      this.selectedPrice = selectedTarif.priceList[priceIndex]; // Odabir cijene iz odabrane tarife
      this.selectedTarifIndex = tarifIndex; // Postavljanje indeksa odabrane tarife
      console.log(this.selectedPrice);
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
  }

  prevSlide() {
    if (this.currentIndex > 0) {
      this.currentIndex--;
    }
  }

  nextSlide() {
    if (this.currentIndex < this.divs.length - 3) {
      this.currentIndex++;
    }
  }

  isActive(index: number): boolean {
    return index === this.currentIndex +1;
  }


}
