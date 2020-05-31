import {
  Component,
  OnInit,
} from '@angular/core'
import {Offer} from "../model/Offer";
import {ActivatedRoute} from "@angular/router";
import {OffersRestService} from "../shared/offers-rest.service";
import {NzModalService} from "ng-zorro-antd/modal";
import {Cities} from "../shared/cities.enum";
import {OfferEditComponent} from "./offer-panel/offer-edit/offer-edit.component";

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
  searchTerm: string;
  searchCity: string;
  cities = Object.values(Cities);

  constructor(private readonly route: ActivatedRoute, private offersRestService: OffersRestService, private modal: NzModalService) {}

  ngOnInit(): void {
    console.log('Offers');
    this.offers = this.route.snapshot.data.offers;
  }


  getColumnsNumber(columns: String) {
    return +columns
  }

  editAdvertisement = (offer) => {
    this.modal.create({
      nzWidth: "60%",
      nzTitle: `Edytuj ${offer.title}`,
      nzContent: OfferEditComponent,
      nzComponentParams: {
        offer: offer,
        cities: this.cities,
        modifyOffer: this.modifyOffer
      }
    });
  }

  confirmDeleteOffer = (offerTitle, offerId) => {
    this.modal.confirm({
      nzTitle: `Potwierdzenie`,
      nzContent: `<b style="color: red;">Czy na pewno chcesz usunąć ofertę: <span>"${offerTitle}"</span>?</b>`,
      nzOkText: 'Usuń',
      nzOkType: 'danger',
      nzOnOk: () => this.deleteOffer(offerId),
      nzCancelText: 'Anuluj',
      nzOnCancel: () => console.log('Deleting offer canceled')
    });
  }

  deleteOffer(offerId) {
    this.offersRestService.deleteOffer(offerId).subscribe(() => {
      this.offers = [...this.offers.filter(({id}) => id !== offerId)]
    });
  }

  modifyOffer = (offerId, offer) => {
    this.offersRestService.modifyOffer(offerId, offer).subscribe((newOffer) => {
      const offerIndex = this.offers.findIndex(({id}) => id === offerId);
      this.offers = [
        ...this.offers.slice(0, offerIndex),
        newOffer,
        ...this.offers.slice(offerIndex + 1, this.offers.length)
      ];
    });
  }

}
