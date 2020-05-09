import {Component, Input, OnInit} from '@angular/core';
import {Advertisement} from "../../model/Advertisement";

@Component({
  selector: 'app-advertisement-panel',
  templateUrl: './advertisement-panel.component.html',
  styleUrls: ['./advertisement-panel.component.css']
})
export class AdvertisementPanelComponent implements OnInit {

  @Input()
  advertisement: Advertisement

  constructor() { }

  ngOnInit(): void {
    console.log(this.advertisement);
  }

}
