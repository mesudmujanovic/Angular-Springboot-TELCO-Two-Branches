import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IinfoUsers } from '../Interface/IinfoUsers';
import { BASE_URL } from '../const/backend-url';

@Injectable({
  providedIn: 'root'
})
export class InformationOfUsersService {

  constructor(private http: HttpClient) { }

  addUsersInfo( name: string, lastName: string, phone: string, email: string ): Observable<IinfoUsers>{
    const requiredValue = { name, lastName, email, phone }
    console.log(name,lastName,email,phone);
    return this.http.post<IinfoUsers>(`${BASE_URL}/usersInfo`,requiredValue);
  }

  getById( userInfoId: number ): Observable<IinfoUsers>{
    return this.http.get<IinfoUsers>(`${BASE_URL}/getById/${userInfoId}`)
  }
}
