import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './component/sign-up/sign-up.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CityComponent } from './component/city/city.component';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { TitleComponent } from './component/title/title.component';
import { CommentCustomerComponent } from './component/comment-customer/comment-customer.component';
import { SlickCarouselModule } from 'ngx-slick-carousel';
import { HeaderComponent } from './layout/header/header.component';
import { MainComponent } from './component/main/main.component';
import { HomeComponent } from './pages/home/home.component';
import { TariffsComponent } from './component/tariffs/tariffs.component';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { TariffsForMainPageComponent } from './component/tariffs-for-main-page/tariffs-for-main-page.component';
import { FooterComponent } from './layout/footer/footer.component';
import { AllRoutersComponent } from './component/routers/all-routers/all-routers.component';
import { Router } from './component/routers/router/router.component';
import { RoutersComponent } from './pages/routers/routers.component';
import { InfoUserComponent } from './pages/info-user/info-user.component';
import { CartComponent } from './component/cart/cart.component';
import { InformationOfUserComponent } from './component/information-of-user/information-of-user.component';
import { FinishPageComponent } from './pages/finish-page/finish-page.component';
import { FinishComponent } from './component/finish/finish.component';
import { StoreModule } from '@ngrx/store';
import { appReducers } from './ngrx-store/reducers/app.reducers';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

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
    TariffsComponent,
    MainPageComponent,
    TariffsForMainPageComponent,
    FooterComponent,
    AllRoutersComponent,
    Router,
    RoutersComponent,
    InfoUserComponent,
    CartComponent,
    InformationOfUserComponent,
    FinishPageComponent,
    FinishComponent
  ],
  imports: [
    BrowserModule,
    SlickCarouselModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    StoreModule.forRoot(appReducers),
    StoreDevtoolsModule.instrument({maxAge:25}),
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
