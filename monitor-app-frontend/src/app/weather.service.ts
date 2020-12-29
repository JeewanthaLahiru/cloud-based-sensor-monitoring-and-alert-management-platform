import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IWeather } from './models/iweather';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  _url="http://localhost:8080/sensors/0001";

  constructor(private _http:HttpClient) { }

  getWeather():Observable<IWeather[]>{
    return this._http.get<IWeather[]>(this._url);
  }

}
