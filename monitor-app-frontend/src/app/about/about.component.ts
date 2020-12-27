import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  users = [
    {
      name:'Jeewantha Lahiru',
      studentNumber:'SE/2017/001',
      part:'front-end',
      image:'../../assets/images/users/about001.png'
    },
    {
      name:'Neminda Prabhashwara',
      studentNumber:'SE/2017/034',
      part:'Back-end',
      image:'../../assets/images/users/about002.png'
    },
    {
      name:'Chanaka Herath',
      studentNumber:'SE/2017/0XX',
      part:'Back-end',
      image: '../../assets/images/users/about003.png'
    },
    {
      name:'Ovindu Archana',
      studentNumber:'SE/2017/0XX',
      part:'Database',
      image:'../../assets/images/users/about004.png'
    },
    {
      name:'Hansa sandamal',
      studentNumber:'SE/2017/0XX',
      part:'data ingestion with NIFI',
      image:'../../assets/images/users/about005.png'
    },
    {
      name:'Dilusha sandaruwani',
      studentNumber:'SE/2017/0XX',
      part:'c4 diagram',
      image:'../../assets/images/users/about006.png'
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
