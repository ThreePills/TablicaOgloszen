import {Component, Input, OnInit} from '@angular/core';
import {Advertisment} from "../../model/Advertisment";

@Component({
  selector: 'app-advertisement-panel',
  templateUrl: './advertisement-panel.component.html',
  styleUrls: ['./advertisement-panel.component.css']
})
export class AdvertisementPanelComponent implements OnInit {

  @Input()
  advertisment: Advertisment

  constructor() { }

  ngOnInit(): void {
  }

}
