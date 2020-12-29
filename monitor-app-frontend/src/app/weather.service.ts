import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IWeather } from './models/iweather';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  _tempUrl="http://localhost:8080/sensors/0001";
  _humidityUrl="http://localhost:8080/sensors/0002";
  _pressureUrl="http://localhost:8080/sensors/0003";

  constructor(private _http:HttpClient) { }

  getWeather():Observable<IWeather[]>{
    return this._http.get<IWeather[]>(this._tempUrl);
  }

  getHumidity():Observable<IWeather[]>{
    return this._http.get<IWeather[]>(this._humidityUrl);
  }

  getPressure():Observable<IWeather[]>{
    return this._http.get<IWeather[]>(this._pressureUrl);
  }

}
