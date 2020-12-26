import { Component, OnInit } from '@angular/core';
import jwt_decode from 'jwt-decode';
import { IWeather } from '../models/iweather';
import { WeatherService } from '../weather.service';
import { Chart } from 'node_modules/chart.js';

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

  _token = localStorage.getItem('token')

  constructor(private _weather: WeatherService) { }

  ngOnInit(): void {
    this.testingKey = ['hello','world']
    console.log(this.testingKey)
    
    this._weather.getWeather().subscribe(data => {
      this.weather = data
      let array1 = []
      let array2 = []
      let i = 0
      data.forEach(function (item) {
        array1[i] = item.date
        array2[i] = Number(item.data_value.slice(0, 2))
        i++
      })
      this.datelist = array1
      this.dataValue = array2
      //console.log(this.datelist)
      var myChart = new Chart('myChart', {
        type: 'line',
        data: {
            labels: this.datelist,
            datasets: [{
                label: '# of Votes',
                data: this.dataValue,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
    })

    console.log(this.datelist)

    

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

}
