import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './component/sign-up/sign-up.component';
import { HomeComponent } from './component/home/home.component';
import { NavbarComponent } from './component/navbar/navbar.component';

const routes: Routes = [
{ path:"", component: SignUpComponent },
{ path:"home", component: HomeComponent },
{ path:"navbar", component: NavbarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
