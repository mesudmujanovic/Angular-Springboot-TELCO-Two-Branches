import { Component } from '@angular/core';
import { Observable, catchError, of, tap, throwError, timeInterval } from 'rxjs';
import { IRouters } from 'src/app/Interface/iRouters';
import { AllRoutersService } from 'src/app/service/all-routers.service';

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


  constructor( private allRoutersService: AllRoutersService ){}

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
    }, 5000)
  }



  ngOnInit(): void{
   this.routers$ = this.allRouters();
   this.routers$.subscribe();
  }

}
