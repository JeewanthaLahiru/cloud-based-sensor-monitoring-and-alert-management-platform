import { Component, OnInit } from '@angular/core';
import { IWeather } from '../models/iweather';
import { WeatherService } from '../weather.service';
import { Chart } from 'node_modules/chart.js';

@Component({
  selector: 'app-temperature',
  templateUrl: './temperature.component.html',
  styleUrls: ['./temperature.component.css']
})
export class TemperatureComponent implements OnInit {

  weather:IWeather[]

  constructor(private _weather:WeatherService) { }

  ngOnInit(): void {
    this._weather.getWeather().subscribe(data=>{
      this.weather = data
      let weatherDate = []
      let weatherValue = []
      this.weather.forEach(function(item){
        weatherDate.push(Number(item.date.slice(-8,-3)))
        weatherValue.push(item.data_value.slice(0,2))
      })

      var myChart = new Chart('myChart', {
        type: 'line',
        data: {
            labels: weatherDate,
            datasets: [{
                label: 'weather',
                data: weatherValue,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            }
        }
    });

    })
  }

}
