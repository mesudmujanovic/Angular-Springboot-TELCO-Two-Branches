import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  showPopUp: boolean = false;
  showPopUp1: boolean = false;

  popUp(){
    setTimeout( () =>{
      this.showPopUp = true;
    }, 500)
  }

  popUp1(){
   setTimeout( () =>{
    this.showPopUp1 = true;
   }, 500)
  }

  hidePopUp(){
    this.showPopUp = false;
  }

  hidePopUp1(){
    this.showPopUp1 = false;
  }
}
