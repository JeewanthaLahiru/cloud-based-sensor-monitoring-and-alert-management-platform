import { Component, OnInit } from '@angular/core';
import { UserLoginModel } from '../UserLoginModel';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user1 = new UserLoginModel("","");

  constructor() { }

  ngOnInit(): void {
  }

  loginUser(){
    console.log(this.user1)
  }

}
