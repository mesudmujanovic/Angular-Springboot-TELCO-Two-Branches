import { Component } from '@angular/core';

declare var bootstrap: any;


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  showPopUp: boolean = false;

  popUp(){
    setTimeout( () =>{
      this.showPopUp = true;
    }, 500)
  }

  hidePopUp(){
    this.showPopUp = false;
  }
}
