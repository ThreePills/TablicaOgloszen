import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Offer} from "../model/Offer";

@Component({
  selector: 'app-offer-form',
  templateUrl: './offer-form.component.html',
  styleUrls: ['./offer-form.component.css']
})
export class OfferFormComponent implements OnInit {

  offerForm;

  @Output() saved = new EventEmitter<Offer>();

  // TODO: add offer rest service
  constructor() {
  }

  ngOnInit(): void {
    console.log("Form component");
    this.offerForm = new FormGroup({
      title: new FormControl('', [Validators.required]),
      content: new FormControl('', [Validators.required, Validators.minLength(10)]),

      contact: new FormGroup({
        name: new FormControl('', [Validators.required]),
        email: new FormControl('', [Validators.required, Validators.email]),
        phoneNumber: new FormControl('', [Validators.required]),
      }),

      localization: new FormGroup({
        country: new FormControl('', [Validators.required]),
        region: new FormControl('', [Validators.required]),
        zipCode: new FormControl('', [Validators.required]),
        localizationName: new FormControl('', [Validators.required]),
      })
    });
  }

  onSubmit(formData) {
    if (this.offerForm.valid) {
      //this.offerService.save(formData).subscribe((offer: Offer) => this.changed.emit(offer));
      this.saved.emit(formData);

      this.offerForm.reset();
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
