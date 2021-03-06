import { Component, OnInit } from '@angular/core';
import { UserLoginModel } from '../UserLoginModel';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user1 = new UserLoginModel("","");

  constructor(private auth:AuthService, private _router:Router) { }

  ngOnInit(): void {
    this.auth.getCurrentUser().subscribe(data=>{
      console.log(data)
      if(data=="Wrong Email" || data == "Wrong Password"){
        alert(data)
      }
    })
  }

  loginUser(){
    console.log(this.user1);
    this.auth.loginUser(this.user1).subscribe(
      res=>{
        console.log(res);
        localStorage.setItem('token',res.jwtToken);
        this._router.navigate(['/profile']);
      },
      err=>console.log(err)
    )
  }

}
