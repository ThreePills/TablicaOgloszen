import {Component, Input, OnInit} from '@angular/core';
import {Offer} from "../../../model/Offer";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-offer-edit',
  templateUrl: './offer-edit.component.html',
  styleUrls: ['./offer-edit.component.css']
})
export class OfferEditComponent implements OnInit {

  validateForm: FormGroup;
  offer: Offer;
  myGroup: any;

  constructor() {}

  ngOnInit(): void {
    this.myGroup = new FormGroup({
      firstName: new FormControl()
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
