import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './component/sign-up/sign-up.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CityComponent } from './component/city/city.component';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from './component/navbar/navbar.component';
import { TitleComponent } from './component/title/title.component';
import { CommentCustomerComponent } from './component/comment-customer/comment-customer.component';
import { SlickCarouselModule } from 'ngx-slick-carousel';
import { HeaderComponent } from './component/header/header.component';
import { MainComponent } from './component/main/main.component';
import { HomeComponent } from './pages/home/home.component';
import { TariffsComponent } from './component/tariffs/tariffs.component';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    CityComponent,
    NavbarComponent,
    TitleComponent,
    CommentCustomerComponent,
    HeaderComponent,
    MainComponent,
    HomeComponent,
    TariffsComponent
  
  ],
  imports: [
    BrowserModule,
    SlickCarouselModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
