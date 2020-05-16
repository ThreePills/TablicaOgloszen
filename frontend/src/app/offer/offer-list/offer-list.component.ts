import {Component, OnInit} from '@angular/core'
import {NewOffer} from "../model/NewOffer";
import {NewContact} from "../model/NewContact";
import {NewLocalization} from "../model/NewLocalization";
import {Offer} from "../model/Offer";

@Component({
  selector: 'app-offer-list',
  templateUrl: './offer-list.component.html',
  styleUrls: ['./offer-list.component.css']
})
export class OfferListComponent implements OnInit {

  offers: NewOffer[] = [];
  hGutter = 16;
  vGutter = 16;
  columns = "3";

  contact = new NewContact("1", "email@example.com", "Name", 111111111);
  localization = new NewLocalization("1", "Polska", "Dolnyśląsk", "54-207", "Wrocław")

  offer1 = new NewOffer("1", 'Ogłoszenie 1', this.contact, this.localization, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. . Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
  offer2 = new NewOffer("2", 'Ogłoszenie 2', this.contact, this.localization, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse ');
  offer3 = new NewOffer("3", 'Ogłoszenie 3', this.contact, this.localization, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
  offer4 = new NewOffer("4", 'Ogłoszenie 4', this.contact, this.localization, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.');

  constructor() {
    this.offers = []
  }

  ngOnInit(): void {
    console.log('Offers');
    this.offers.push(this.offer1);
    this.offers.push(this.offer2);
    this.offers.push(this.offer3);
    this.offers.push(this.offer4);
  }

  getColumnsNumber(columns: String) {
    return +columns
  }
}
