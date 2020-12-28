import { Component, OnInit } from '@angular/core';
import { Chart } from 'node_modules/chart.js';

@Component({
  selector: 'app-humidity',
  templateUrl: './humidity.component.html',
  styleUrls: ['./humidity.component.css']
})
export class HumidityComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    var myChart = new Chart('myChart', {
      type: 'line',
      data: {
          labels: ['label1','label2','label3','label4','label5'],
          datasets: [{
              label: 'Temperature',
              data: [88,89,90,80,40],
              backgroundColor: 'rgba(255, 207, 15, 0.2)',
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
                    labelString:'Humidity(%)'
                  }
              }]
          }
      }
  });
  }

}
