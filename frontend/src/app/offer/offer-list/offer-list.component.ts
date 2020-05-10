import {Component, OnInit} from '@angular/core'
import {Offer} from "../model/Offer";
import {NewOffer} from "../model/NewOffer";

@Component({
  selector: 'app-offer-list',
  templateUrl: './offer-list.component.html',
  styleUrls: ['./offer-list.component.css']
})
export class OfferListComponent implements OnInit {

  offers: Offer[] = [];
  hGutter = 16;
  vGutter = 16;
  columns = "3";

  offer1 = new NewOffer('1', 'Ogłoszenie 1', '111-111-111', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. . Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
  offer2 = new NewOffer('2', 'Ogłoszenie 2', '111-111-111', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse ');
  offer3 = new NewOffer('3', 'Ogłoszenie 3', '111-111-111', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
  offer4 = new NewOffer('4', 'Ogłoszenie 4', '111-111-111', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.');

  constructor() {
    this.offers = []
  }

  ngOnInit(): void {
    console.log('Offers');
    this.offers.push(this.offer1);
    this.offers.push(this.offer2);
    this.offers.push(this.offer3);
    this.offers.push(this.offer4);
    console.log(this.offers);
  }

  getColumnsNumber(columns: String) {
    return +columns
  }
}
