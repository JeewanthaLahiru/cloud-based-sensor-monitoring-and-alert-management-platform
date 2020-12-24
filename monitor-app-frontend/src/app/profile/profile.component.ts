import { Component, OnInit } from '@angular/core';
import jwt_decode from 'jwt-decode';
import { IWeather } from '../models/iweather';
import { WeatherService } from '../weather.service';
import { Chart } from 'node_modules/chart.js';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  weather: IWeather[];
  datelist = []
  dataValue = []

  _token = localStorage.getItem('token')

  constructor(private _weather: WeatherService) { }

  ngOnInit(): void {
    this._weather.getWeather().subscribe(data => {
      this.weather = data
      let array1 = []
      let array2 = []
      let i = 0
      data.forEach(function(item){
        array1[i] = item.date
        array2[i] = Number(item.data_value.slice(0,2))
        i++
      })
      console.log(array2)
      this.datelist = array1
      this.dataValue = array2
    })
    

  }

  getDecodedAccessToken(token: string): any {
    try {
      return jwt_decode(token);
    }
    catch (Error) {
      return null;
    }
  }

}
