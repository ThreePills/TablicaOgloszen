import { Component, Input, OnInit } from '@angular/core';
import { Offer } from '../../model/Offer';

@Component({
  selector: 'app-offer-panel',
  templateUrl: './offer-panel.component.html',
  styleUrls: ['./offer-panel.component.css'],
})
export class OfferPanelComponent implements OnInit {
  @Input()
  offer: Offer;
  @Input()
  confirmDeleteOffer;
  @Input()
  editAdvertisement;
  deleted: boolean;

  constructor() {}

  ngOnInit(): void {
    console.log(this.offer);
  }
  deleteOffer() {
    this.confirmDeleteOffer(this.offer.title, this.offer.id);
    this.deleted = true;
  }
}
