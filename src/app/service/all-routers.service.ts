import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IRouters } from '../Interface/iRouters'
import { BASE_URL } from '../const/backend-url';

@Injectable({
  providedIn: 'root'
})

export class AllRoutersService {

  constructor( private http: HttpClient ) { }

  addRouters( description: string, price: number ): Observable<IRouters>{
    const post = { description, price };
    return this.http.post<IRouters>(`${BASE_URL}/addRouter`,post);
  }

  getAllRouters(): Observable<IRouters[]>{
    return this.http.get<IRouters[]>(`${BASE_URL}/getAllRouters`);
  }


}
