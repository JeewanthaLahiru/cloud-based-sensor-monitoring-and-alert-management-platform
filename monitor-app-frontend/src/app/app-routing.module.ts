import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AuthGuard } from './auth.guard';
import { HomeComponent } from './home/home.component';
import { HumidityComponent } from './humidity/humidity.component';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { NotificationComponent } from './notification/notification.component';
import { PressureComponent } from './pressure/pressure.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { TemperatureComponent } from './temperature/temperature.component';


const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {
    path:'profile',
    component:ProfileComponent,
    canActivate:[AuthGuard],
    children:[
      {path:'',redirectTo:'/profile/temperature',pathMatch:'full'},
      {path:'temperature',component:TemperatureComponent},
      {path:'humidity',component:HumidityComponent},
      {path:'pressure',component:PressureComponent}
    ]
  },
  {path:'about',component:AboutComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'**',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
