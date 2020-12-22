import { Component, OnInit } from '@angular/core';
import { UserRegisterModel } from '../UserRegisterModel';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user1 = new UserRegisterModel('','','','','');

  checkBoxStatus:boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  registerUser(){
    console.log(this.user1);
  }

}
