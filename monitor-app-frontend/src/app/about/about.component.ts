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
      image:'../../assets/images/users/about001.png',
      fbLink:'https://www.facebook.com/jeewantha.lahiru.9/',
      linkdlink:'https://www.linkedin.com/in/jeewantha-lahiru-b85b2917b/',
      instalink:'https://www.instagram.com/jilerr/'
    },
    {
      name:'Neminda Prabhashwara',
      studentNumber:'SE/2017/034',
      part:'Back-end',
      image:'../../assets/images/users/about002.png',
      fbLink:'https://www.facebook.com/profile.php?id=100009057069345',
      linkdlink:'https://www.linkedin.com/in/neminda-piyasena/',
      instalink:'#'
    },
    {
      name:'Chanaka Herath',
      studentNumber:'SE/2017/017',
      part:'Back-end',
      image: '../../assets/images/users/about003.png',
      fbLink:'https://www.facebook.com/chanaka.herath.3150',
      linkdlink:'https://www.linkedin.com/in/chanaka-madushan-123b2b17b/',
      instalink:'https://www.instagram.com/chanaka_m_herath/'
    },
    {
      name:'Ovindu Archana',
      studentNumber:'SE/2017/0XX',
      part:'Database',
      image:'../../assets/images/users/about004.png',
      fbLink:'https://www.facebook.com/profile.php?id=100008683652038',
      linkdlink:'https://www.linkedin.com/in/ovindu-archana-nambukara-325771181/',
      instalink:'https://www.instagram.com/ovindunambukara/'
    },
    {
      name:'Hansa sandamal',
      studentNumber:'SE/2017/039',
      part:'data ingestion with NIFI',
      image:'../../assets/images/users/about005.png',
      fbLink:'https://www.facebook.com/hansa.sandamal',
      linkdlink:'https://www.linkedin.com/in/hansa-sandamal-a2232817b/',
      instalink:'https://www.instagram.com/_hansa_sandamal_/'
    },
    {
      name:'Dilusha sandaruwani',
      studentNumber:'SE/2017/0XX',
      part:'c4 diagram',
      image:'../../assets/images/users/about006.png',
      fbLink:'https://www.facebook.com/dilusha.sandaruwani.1',
      linkdlink:'#',
      instalink:'#'
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
