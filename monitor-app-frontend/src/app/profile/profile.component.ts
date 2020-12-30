import { Component, OnInit } from '@angular/core';
import jwt_decode from 'jwt-decode';
import { IWeather } from '../models/iweather';
import { WeatherService } from '../weather.service';
import { Router } from "@angular/router";
import { AuthService } from '../auth.service';
import { UserRegisterModel } from '../UserRegisterModel';
import { CurrentUser } from '../CurrentUser';
import { Subscription } from 'rxjs';
import { NotificationService } from '../notification.service';

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

  private sseStream:Subscription;
  messages:Array<string> = []

  name:string
  email:string
  phone:string
  notification:string

  notificationMethod:string

  _token = localStorage.getItem('token')

  constructor(private _weather: WeatherService,private _route:Router,private _auth:AuthService,private sseService:NotificationService) { }

  ngOnInit(): void {

    this.sseStream = this.sseService.observerMessages('http://localhost:8080/notification/mongodb').subscribe(message =>{
      this.messages.push(message);
      console.log(message)
    })

    
    
    this._weather.getWeather().subscribe(data => {
      this.weather = data      
    })

    this._auth.getCurrentUser().subscribe(data=>{
      console.log(data)
      this.name = data.name
      this.email = data.email
      this.phone = data.phone
      this.notification = data.notification
      if(data=="Wrong Email" || data == "Wrong Password"){
        this._route.navigate(['login']);
      }
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

  onSelect(){
    this._route.navigate(['/profile',1])
  }

}
