import { Component, OnInit } from '@angular/core';
import { UserRegisterModel } from '../UserRegisterModel';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user1 = new UserRegisterModel('','','','','');

  checkBoxStatus:boolean = false;

  constructor(private auth:AuthService) { }

  ngOnInit(): void {
  }

  registerUser(){
    console.log(this.user1);
    this.auth.registerUser(this.user1).subscribe(
      res=>{
        console.log(res);
        localStorage.setItem('token',res.token);
      },
      err=>console.log(err)
    )
  }

}
