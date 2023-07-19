import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BACKEND_URL } from '../constants/Backend.url';
import { UserJWT } from '../Interface/UserJWT';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor( private http: HttpClient ) { }

  login( username: string, password: string ): Observable<UserJWT>{
    const login = { username, password  }
    return this.http.post<UserJWT>(`${BACKEND_URL}/auth/login`,login)
  }
}
