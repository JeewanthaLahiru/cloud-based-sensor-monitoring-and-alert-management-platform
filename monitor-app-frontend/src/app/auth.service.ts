import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserRegisterModel } from './UserRegisterModel';
import { UserLoginModel } from './UserLoginModel';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _registerUrl = "http://localhost:3000/api/register";
  private _loginUrl = "http://localhost:3000/api/login";
  private _getCurrentUserUrl = "http://localhost:3000/api/getCurrentUser";

  constructor(private _http:HttpClient) { }

  registerUser(user:UserRegisterModel){
    return this._http.post<any>(this._registerUrl,user);
  }

  loginUser(user:UserLoginModel){
    return this._http.post<any>(this._loginUrl,user);
  }

  loggedIn(){
    return !!localStorage.getItem('token');
  }

  getToken(){
    return localStorage.getItem('token');
  }

  getCurrentUser(){
    let token = localStorage.getItem('token');
    return this._http.post<any>(this._getCurrentUserUrl,token);
  }

}
