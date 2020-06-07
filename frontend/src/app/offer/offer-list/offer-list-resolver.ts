import {
  ActivatedRouteSnapshot,
  Resolve,
  RouterStateSnapshot,
} from '@angular/router';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Offer } from '../model/Offer';
import { OffersRestService } from '../shared/offers-rest.service';

@Injectable({
  providedIn: 'root',
})
export class OfferListResolver implements Resolve<Offer[] | null> {
  constructor(private readonly offersService: OffersRestService) {}

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<Offer[] | null> | Offer[] | null {
    return this.offersService.findAll();
  }
}
