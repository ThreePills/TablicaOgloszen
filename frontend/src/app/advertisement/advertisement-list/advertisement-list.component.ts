import { Component, OnInit } from '@angular/core';
import {Advertisment} from "../model/Advertisment";
import {NewAdvertisment} from "../model/NewAdvertisment";

@Component({
  selector: 'app-advertisement-list',
  templateUrl: './advertisement-list.component.html',
  styleUrls: ['./advertisement-list.component.css']
})
export class AdvertisementListComponent implements OnInit {

  advertisments: Advertisment[] = [];
  hGutter = 16;
  vGutter = 16;
  columns = 3;

  add1 = new NewAdvertisment('1','Ogłoszenie 1', '111-111-111','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. . Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
  add2 = new NewAdvertisment('2','Ogłoszenie 2', '111-111-111','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse ');
  add3 = new NewAdvertisment('3','Ogłoszenie 3', '111-111-111','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
  add4 = new NewAdvertisment('4','Ogłoszenie 4', '111-111-111','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.');


  constructor() {
    this.advertisments = []
  }

  ngOnInit(): void {
    console.log('Advertisment');
    this.advertisments.push(this.add1);
    this.advertisments.push(this.add2);
    this.advertisments.push(this.add3);
    this.advertisments.push(this.add4);
  }
}
