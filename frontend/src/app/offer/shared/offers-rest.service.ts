import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Offer } from '../model/Offer';

@Injectable({
  providedIn: 'root',
})
export class OffersRestService {
  private OFFERS_ENDPOINT = 'http://localhost:8080/offer';
  private isActive = true;

  constructor(private readonly http: HttpClient) {}

  findAll(): Observable<Offer[]> {
    return this.http.get<Offer[]>(
      `${this.OFFERS_ENDPOINT}/list/${this.isActive}`
    );
  }

  deleteOffer(offerId: string) {
    return this.http.delete<Offer>(`${this.OFFERS_ENDPOINT}/${offerId}`);
  }

  modifyOffer(offerId: string, offer: Offer): Observable<Offer> {
    const { name, phoneNumber, email }: any = offer;
    const { country, region, zipCode, localizationName }: any = offer;

    return this.http.post<Offer>(`${this.OFFERS_ENDPOINT}`, {
      id: offerId,
      content: offer.content,
      title: offer.title,
      isActive: true,
      contact: { name, phoneNumber, email },
      localization: { country, region, zipCode, localizationName },
    });
  }

  save(offer: Offer): Observable<Offer> {
    return this.http.post<Offer>(`${this.OFFERS_ENDPOINT}`, offer);
  }
}
