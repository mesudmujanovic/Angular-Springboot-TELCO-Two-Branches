import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { IRouters } from 'src/app/Interface/iRouters';
import { AllRoutersService } from 'src/app/service/all-routers.service';
import { LocalStorageService } from 'src/app/service/local-storage.service';

@Component({
  selector: 'app-all-routers',
  templateUrl: './all-routers.component.html',
  styleUrls: ['./all-routers.component.css']
})
export class AllRoutersComponent {

  routers$: Observable<IRouters[]>
  selectedRouter: IRouters;
  orderFinish: boolean = false;
  seconds: number = 5;

  constructor( private allRoutersService: AllRoutersService,
               private router: Router,
               private localStorageService: LocalStorageService ){}

  allRouters(): Observable<IRouters[]>{
    return this.allRoutersService.getAllRouters().pipe(
      tap( response =>{
      }),
      catchError((error)=>{
        console.error('Grreska prilikom dohvatanja',error);
        return throwError('Doslo je do greske');
      })
    )
  }

  onAddRouter(routers: IRouters) {
    this.selectedRouter = routers;
    const routerPrice = this.selectedRouter.price
    this.localStorageService.setLocalStorage('routerPrice', routerPrice)
    this.orderFinish = true;
    const secondstInteval = setInterval(()=>{
     if(this.seconds > 0){
      this.seconds --;
     }else{
      this.seconds = 0;
     }
    },1000)
setInterval( () =>{
      this.orderFinish = false
      clearInterval(secondstInteval);
      this.router.navigate(['/info'])
    }, 5000)
  }

  ngOnInit(): void{
   this.routers$ = this.allRouters();
   this.routers$.subscribe();
  }

}
