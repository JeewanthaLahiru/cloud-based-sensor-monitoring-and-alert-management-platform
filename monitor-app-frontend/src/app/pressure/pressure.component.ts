import { Component, OnInit } from '@angular/core';
import { Chart } from 'node_modules/chart.js';
import { IWeather } from '../models/iweather';
import { WeatherService } from '../weather.service';

@Component({
  selector: 'app-pressure',
  templateUrl: './pressure.component.html',
  styleUrls: ['./pressure.component.css']
})
export class PressureComponent implements OnInit {

  weather:IWeather[]

  constructor(private _weather:WeatherService) { }

  ngOnInit(): void {
    this._weather.getPressure().subscribe(data=>{
      this.weather = data
      let weatherDate = []
      let weatherValue = []
      this.weather.forEach(function(item){
        weatherDate.push(item.date.slice(-8,-3))
        weatherValue.push(Number(item.data_value.slice(0,2)))
      })
      //console.log(weatherDate)
      var myChart = new Chart('myChart', {
        type: 'line',
        data: {
            labels: weatherDate,
            datasets: [{
                label: 'Pressure',
                data: weatherValue,
                backgroundColor: 'rgba(255, 15, 15, 0.2)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    },
                    scaleLabel:{
                      display:true,
                      labelString:'Temperature(\'C)'
                    }
                }]
            }
        }
    });

    })
    
  }

}
