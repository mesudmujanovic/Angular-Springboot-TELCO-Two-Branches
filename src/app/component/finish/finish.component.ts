import { Component } from '@angular/core';
import { Observable, map, tap } from 'rxjs';
import { IinfoUsers } from 'src/app/Interface/IinfoUsers';
import { InformationOfUsersService } from 'src/app/service/information-of-users.service';
import { LocalStorageService } from 'src/app/service/local-storage.service';

@Component({
  selector: 'app-finish',
  templateUrl: './finish.component.html',
  styleUrls: ['./finish.component.css']
})
export class FinishComponent {

  userInfoId: number;
  showUserInfo: Observable<IinfoUsers>;

  constructor(
    private infoUserService: InformationOfUsersService,
    private localStorage: LocalStorageService)
    {}

    getUserInfo(): Observable<IinfoUsers> {
      return this.infoUserService.getById(this.userInfoId).pipe(
        tap(() => {
        })
      );
    }

  ngOnInit(): void{
   this.userInfoId = this.localStorage.getLocalStorage("userInfoId")
   this.showUserInfo =  this.getUserInfo();
   this.showUserInfo.subscribe( user => console.log(user));
  }

  

}
