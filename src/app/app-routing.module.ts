import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './component/sign-up/sign-up.component';
import { HomeComponent } from './pages/home/home.component';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { RoutersComponent } from './pages/routers/routers.component';
import { InfoUserComponent } from './pages/info-user/info-user.component';
import { FinishPageComponent } from './pages/finish-page/finish-page.component';

const routes: Routes = [
{ path:"", component: SignUpComponent },
{ path:"home", component: HomeComponent },
{ path:"main-page", component: MainPageComponent},
{ path:"routers", component: RoutersComponent },
{ path:"info", component: InfoUserComponent },
{ path:"finish", component: FinishPageComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
