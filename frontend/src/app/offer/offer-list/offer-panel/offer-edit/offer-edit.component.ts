import {Component, Input, OnInit} from '@angular/core';
import {Offer} from "../../../model/Offer";
import {FormControl, FormGroup} from "@angular/forms";
import {Cities} from "../../../shared/cities.enum";

@Component({
  selector: 'app-offer-edit',
  templateUrl: './offer-edit.component.html',
  styleUrls: ['./offer-edit.component.css']
})
export class OfferEditComponent implements OnInit {

  validateForm: FormGroup;
  offer: Offer;
  cities: Cities[]

  constructor() {}

  ngOnInit(): void {
    this.validateForm = new FormGroup({
      title: new FormControl(),
      name: new FormControl(),
      phone: new FormControl(),
      email: new FormControl(),
      country: new FormControl(),
      region: new FormControl(),
      city: new FormControl(),
      zipCode: new FormControl()
    });
  }

  submitForm(value: { userName: string; email: string; password: string; confirm: string; comment: string }): void {
    for (const key in this.validateForm.controls) {
      this.validateForm.controls[key].markAsDirty();
      this.validateForm.controls[key].updateValueAndValidity();
    }
    console.log(value);
  }

}
