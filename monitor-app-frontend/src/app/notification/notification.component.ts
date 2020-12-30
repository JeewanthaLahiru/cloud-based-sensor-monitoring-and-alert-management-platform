import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {

  constructor(private _aroute:ActivatedRoute) { }
  public id;
  

  ngOnInit(): void {
    let newid = parseInt(this._aroute.snapshot.paramMap.get('id'));
    this.id = newid
  }

}
