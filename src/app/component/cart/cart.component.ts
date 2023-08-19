import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CartService } from 'src/app/service/cart.service';
import { LocalStorageService } from 'src/app/service/local-storage.service';
import { Observable, catchError, of, tap, throwError } from 'rxjs';
import { ITariff } from 'src/app/Interface/ITariff';
import { IPrice } from 'src/app/Interface/IPrice-interface';
import { IRouters } from 'src/app/Interface/iRouters';
import { CalculatorService } from '../../service/calculator.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  tariffId: number;
  routerId: number;
  priceId: number;
  choseRouter: Observable<IRouters>;
  choosePrice: Observable<IPrice>;
  chooseTariff: Observable<ITariff>;
  calculatePriceTariff: number;
  result: number;
  priceTariff:number;
  priceRouter:number;
  showCart: boolean = false;

  constructor(private http: HttpClient,
    private cartService: CartService,
    private localStorage: LocalStorageService,
    private calculatorService: CalculatorService) {
     }

  routerTariffTotal(){
    this.calculatorService.calculateRouterAndTariff( this.priceTariff, this.priceRouter).pipe(
      tap( (res) =>{
        this.result = res.calculatedPrice 
      })
    ).subscribe()
  }

  hidePopUp1(){
    this.showCart = false
  }
 
  addTariffInCart(): Observable<any> {
    return this.cartService.adaTariffInCart(this.tariffId).pipe(
      tap((res: ITariff) => {
        const resp = res.priceList;
        this.chooseTariff = of(res);
        const filterPriceList: IPrice[] = resp.filter((res) => res.id == this.priceId);
        this.choosePrice = of(filterPriceList[0])
      }),
      catchError((error) => {
        console.error("greska prilikom dohvatanja", error);
        return throwError('doslo je do greske');
      })
    )
  };

  addRouterInCart(): Observable<IRouters> {
    return this.cartService.adaRouterInCart(this.routerId).pipe(
      tap((res: IRouters) => {
      }),
      catchError((error) => {
        console.error("greska prilijkom dohvaanja", error);
        return throwError('doslo je dogreske')
      })
    )
  }

  ngOnInit() {
    this.tariffId = this.localStorage.getLocalStorage('tariffId');
    this.routerId = this.localStorage.getLocalStorage('routerId');
    this.priceId = this.localStorage.getLocalStorage('priceId');
    this.priceTariff = this.localStorage.getLocalStorage('price');
    this.priceRouter = this.localStorage.getLocalStorage('routerPrice');
    this.calculatePriceTariff = this.localStorage.getLocalStorage('price');
    this.addTariffInCart().subscribe()
    this.addRouterInCart().subscribe()
    this.choseRouter = this.addRouterInCart();
    this.choseRouter.subscribe()
    this.routerTariffTotal();
  }

}
