import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserRegisterModel } from './UserRegisterModel';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _registerUrl = "http://localhost:3000/api/register";

  constructor(private _http:HttpClient) { }

  registerUser(user:UserRegisterModel){
    return this._http.post<any>(this._registerUrl,user);
  }

}
