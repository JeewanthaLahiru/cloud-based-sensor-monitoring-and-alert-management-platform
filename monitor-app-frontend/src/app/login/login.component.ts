import { Component, OnInit } from '@angular/core';
import { UserLoginModel } from '../UserLoginModel';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user1 = new UserLoginModel("","");

  constructor(private auth:AuthService) { }

  ngOnInit(): void {
  }

  loginUser(){
    console.log(this.user1);
    this.auth.loginUser(this.user1).subscribe(
      res=>console.log(res),
      err=>console.log(err)
    )
  }

}
