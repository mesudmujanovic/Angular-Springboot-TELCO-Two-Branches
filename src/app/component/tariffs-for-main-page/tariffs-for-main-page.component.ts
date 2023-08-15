import { Component } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { ITariff } from 'src/app/Interface/ITariff';
import { CalculatorService } from 'src/app/service/calculator.service';
import { LocalStorageService } from 'src/app/service/local-storage.service';
import { TariffService } from 'src/app/service/tariff.service';

@Component({
  selector: 'app-tariffs-for-main-page',
  templateUrl: './tariffs-for-main-page.component.html',
  styleUrls: ['./tariffs-for-main-page.component.css']
})
export class TariffsForMainPageComponent {

  tariffs: Observable<ITariff[]>;
  currentIndex = 0;
  selectedPrice: any
  selectedTarifIndex: number = -1;
  details: boolean = false;
  price: number;
  discount: number;
  calculatedPrice: number;
  orderSave: boolean = false;

  constructor( private tariffService: TariffService, private calculatorService: CalculatorService,
    private localStorage: LocalStorageService ){}

calculatePriceBackend() {
  this.calculatorService.calculate(this.price, this.discount).pipe(    
    tap( response =>{
    this.calculatedPrice = response.calculatedPrice;    
    this.localStorage.setLocalStorage('price', this.calculatedPrice)
    })
  ).subscribe();
}

  showPriceList(tarifIndex: number, priceIndex: number) {
    this.tariffs.subscribe(tariffs => {
      console.log("tariffs",tariffs);
      console.log("priceIndex",priceIndex);
      const selectedTarif = tariffs[tarifIndex]; 
      console.log("selectedTariff", selectedTarif);
      this.selectedPrice = selectedTarif.priceList[priceIndex]; 
      console.log("selectedPrice", this.selectedPrice);
      this.selectedTarifIndex = tarifIndex; 
      console.log("selectedTariffIndex", this.selectedTarifIndex);    
      this.price = this.selectedPrice.price;
      this.discount = this.selectedPrice.discount;
    });
  }
  
   allTariffs(){
    return this.tariffs = this.tariffService.getAllTariffs().pipe(
      tap( response => {
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

  saveOrder(){
    this.selectedPrice; 
    const priceId = this.selectedPrice.id;
    const tariffId = this.selectedPrice.tariffId
    this.localStorage.setLocalStorage('priceId', priceId);
    this.localStorage.setLocalStorage('tariffId', tariffId);
    this.calculatedPrice;
    this.details = false;
    this.orderSave = true;
    setInterval( () =>{
      this.orderSave = false
    }, 2000)
  }

}
