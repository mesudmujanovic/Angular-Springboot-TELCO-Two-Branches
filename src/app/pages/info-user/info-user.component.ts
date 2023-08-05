import { Component } from '@angular/core';
import { LocalStorageService } from 'src/app/service/local-storage.service';

@Component({
  selector: 'app-info-user',
  templateUrl: './info-user.component.html',
  styleUrls: ['./info-user.component.css']
})
export class InfoUserComponent {

  router: number;
  tariff: number;

  constructor(private localStorage: LocalStorageService){}

  getRouter(): number{
    return this.router = this.localStorage.getLocalStorage('routerPrice');
  }

  getTariff(): number{
    return this.tariff = this.localStorage.getLocalStorage('price');

  }

  ngOnInit(){
    this.getRouter();
    this.getTariff();
  }
  }

