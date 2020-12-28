import { Component, OnInit } from '@angular/core';
import { Chart } from 'node_modules/chart.js';

@Component({
  selector: 'app-pressure',
  templateUrl: './pressure.component.html',
  styleUrls: ['./pressure.component.css']
})
export class PressureComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    var myChart = new Chart('myChart', {
      type: 'line',
      data: {
          labels: ['label1','label2','label3','label4','label5','label1','label2','label3','label4','label5','label1','label2','label3','label4','label5'],
          datasets: [{
              label: 'Temperature',
              data: [65,55,65,70,71,72,70,65,66,63,65,55,65,75,71],
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
                    labelString:'Pressure'
                  }
              }]
          }
      }
  });
  }

}
