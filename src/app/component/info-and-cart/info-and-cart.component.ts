import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CartService } from 'src/app/service/cart.service';
import { LocalStorageService } from 'src/app/service/local-storage.service';
import { Router } from '../routers/router/router.component';
import { Observable, catchError, of, tap, throwError } from 'rxjs';
import { ITariff } from 'src/app/Interface/ITariff';
import { IPrice } from 'src/app/Interface/IPrice-interface';
import { IRouters } from 'src/app/Interface/iRouters';

@Component({
  selector: 'app-info-and-cart',
  templateUrl: './info-and-cart.component.html',
  styleUrls: ['./info-and-cart.component.css']
})
export class InfoAndCartComponent {

tariffId: number;
routerId: number;
priceId: number;
choseRouter: Observable<IRouters>;
choosePrice: Observable<IPrice>;
chooseTariff: Observable<ITariff>;


constructor( private http: HttpClient,
             private cartService: CartService,
             private localStorage: LocalStorageService ){}


addTariffInCart(): Observable<any>{
return this.cartService.adaTariffInCart(this.tariffId).pipe(
  tap( (res: ITariff) =>{
    console.log("res",res);
    const resp = res.priceList;
    this.chooseTariff = of(res);
    //vrati mi Price koju je client izabrao u tariff
    const filterPriceList: IPrice[] = resp.filter( (res)=> res.id == this.priceId);  
    this.choosePrice = of(filterPriceList[0]) 
    console.log("filter", filterPriceList);
    console.log("chose", this.choosePrice);
  }),
  catchError( (error) =>{
    console.error( "greska prilikom dohvatanja", error );
    return throwError('doslo je do greske');
  })
)
};

addRouterInCart(): Observable<IRouters>{
return this.cartService.adaRouterInCart(this.routerId).pipe(
  tap( (res: IRouters) => {
    console.log("router",res);
  }),
  catchError((error)=>{
    console.error("greska prilijkom dohvaanja", error);
    return throwError('doslo je dogreske')
  })
)
}

 ngOnInit(){
 this.tariffId = this.localStorage.getLocalStorage('tariffId');
 this.routerId = this.localStorage.getLocalStorage('routerId');
this.priceId = this.localStorage.getLocalStorage('priceId')
this.addTariffInCart().subscribe()
this.addRouterInCart().subscribe()
this.choseRouter = this.addRouterInCart();
this.choseRouter.subscribe()
}

}
