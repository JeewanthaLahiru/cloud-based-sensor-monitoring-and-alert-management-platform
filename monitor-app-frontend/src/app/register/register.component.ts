import { Component, OnInit } from '@angular/core';
import { UserRegisterModel } from '../UserRegisterModel';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user1 = new UserRegisterModel('','','','','');

  checkBoxStatus:boolean = false;

  constructor(private auth:AuthService, private _router:Router) { }

  ngOnInit(): void {
  }

  registerUser(){
    
    this.auth.registerUser(this.user1).subscribe(
      res=>{
        console.log(res);
        localStorage.setItem('token',res.jwtToken);
        if(res == "Email already registered"){
          alert("Email is already registerd")
        }else{
          this._router.navigate(['/profile']);
        }
        
      },
      err=>console.log(err)
    )
  }

}
