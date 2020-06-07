import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Offer } from '../model/Offer';
import { OffersRestService } from '../shared/offers-rest.service';
import { Cities } from '../shared/cities.enum';
import { NzModalService } from 'ng-zorro-antd/modal';
import { Router } from '@angular/router';

@Component({
  selector: 'app-offer-form',
  templateUrl: './offer-form.component.html',
  styleUrls: ['./offer-form.component.css'],
})
export class OfferFormComponent implements OnInit {
  offerForm;
  keys = Object.keys;
  cities = Cities;

  constructor(
    private readonly offersService: OffersRestService,
    private modal: NzModalService,
    private router: Router
  ) {}

  ngOnInit(): void {
    console.log('Form component');
    this.offerForm = new FormGroup({
      title: new FormControl('', [Validators.required]),
      content: new FormControl('', [
        Validators.required,
        Validators.minLength(10),
      ]),

      contact: new FormGroup({
        name: new FormControl('', [Validators.required]),
        email: new FormControl('', [Validators.required, Validators.email]),
        phoneNumber: new FormControl('', [
          Validators.required,
          Validators.minLength(6),
          Validators.maxLength(10),
        ]),
      }),

      localization: new FormGroup({
        country: new FormControl('', [Validators.required]),
        region: new FormControl('', [Validators.required]),
        zipCode: new FormControl('', [Validators.required]),
        localizationName: new FormControl(this.cities.WROCLAW, [
          Validators.required,
        ]),
      }),
    });
  }

  onSubmit(formData) {
    if (this.offerForm.valid) {
      this.offersService.save(formData).subscribe(
        (offer: Offer) => console.log(offer),
        (err) =>
          this.modal.error({
            nzTitle: `Niestety wystąpił błąd`,
            nzContent: `${err.message}`,
          }),
        () => this.router.navigate([''])
      );
    }
  }

  get title() {
    return this.offerForm.get('title');
  }

  get content() {
    return this.offerForm.get('content');
  }

  get name() {
    return this.offerForm.get('contact.name');
  }

  get email() {
    return this.offerForm.get('contact.email');
  }

  get phoneNumber() {
    return this.offerForm.get('contact.phoneNumber');
  }

  get country() {
    return this.offerForm.get('localization.country');
  }

  get region() {
    return this.offerForm.get('localization.region');
  }

  get zipCode() {
    return this.offerForm.get('localization.zipCode');
  }

  get localizationName() {
    return this.offerForm.get('localization.localizationName');
  }
}
