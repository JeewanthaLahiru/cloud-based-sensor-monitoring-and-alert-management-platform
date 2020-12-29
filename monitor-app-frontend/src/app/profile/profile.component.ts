import { Component, OnInit } from '@angular/core';
import jwt_decode from 'jwt-decode';
import { IWeather } from '../models/iweather';
import { WeatherService } from '../weather.service';
import { Router } from "@angular/router";
import { AuthService } from '../auth.service';
import { UserRegisterModel } from '../UserRegisterModel';
import { CurrentUser } from '../CurrentUser';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  weather: IWeather[];
  public datelist: String[]
  dataValue: String[]
  chart : []
  testingValue = 35
  testingKey:String[]

  name:string
  email:string
  phone:string

  _token = localStorage.getItem('token')

  constructor(private _weather: WeatherService,private _route:Router,private _auth:AuthService) { }

  ngOnInit(): void {

    

    this.testingKey = ['hello','world']
    console.log(this.testingKey)
    
    this._weather.getWeather().subscribe(data => {
      this.weather = data      
    })

    this._auth.getCurrentUser().subscribe(data=>{
      console.log(data)
      this.name = data.name
      this.email = data.email
      this.phone = data.phone
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

  copyArray(arrempty:String[],arr2:String[]){
    arr2.forEach(function(item){
      arrempty.push(item)
    })
  }


  logOut(){
    localStorage.removeItem('token');
    this._route.navigate(['/login'])
  }

}
