import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Racer} from "./racer";

@Injectable({
  providedIn: 'root'
})
export class RacerService {

  constructor(private http: HttpClient) { }

  public createRacer(racer: any): Observable<any> {
    return this.http.post('/api/racer', racer);
  }

  public findAll(): Observable<Racer[]> {
    return this.http.get<Racer[]>('/api/racer');
  }
}
