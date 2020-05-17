import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Offer} from "../model/Offer";

@Injectable({
  providedIn: 'root'
})
export class OffersRestService {

  private OFFERS_ENDPOINT = 'http://localhost:8080/advertisement';

  constructor(private readonly http: HttpClient) {
  }

  findAll(): Observable<Offer[]> {
    return this.http.get<Offer[]>(`${this.OFFERS_ENDPOINT}/allActive`);
  }

  deleteOffer(offerId: string) {
    return this.http.delete<Offer>(`${this.OFFERS_ENDPOINT}/${offerId}`);
  }
}
