import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  _url="http://localhost:3000/api/sensordata";

  constructor(private _http:HttpClient) { }

  getWeather(){
    return this._http.get<any>(this._url);
  }

}
