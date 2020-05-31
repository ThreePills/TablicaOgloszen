import {Component, Input, OnInit} from '@angular/core';
import {Offer} from "../../../model/Offer";
import {FormControl, FormGroup} from "@angular/forms";
import {Cities} from "../../../shared/cities.enum";
import {NzModalRef} from "ng-zorro-antd";

@Component({
  selector: 'app-offer-edit',
  templateUrl: './offer-edit.component.html',
  styleUrls: ['./offer-edit.component.css']
})
export class OfferEditComponent implements OnInit {

  validateForm: FormGroup;
  offer: Offer;
  cities: Cities[];
  modifyOffer: any;
  isVisible = true;

  constructor(private modal: NzModalRef) {}

  ngOnInit(): void {
    this.validateForm = new FormGroup({
      title: new FormControl(),
      name: new FormControl(),
      phoneNumber: new FormControl(),
      email: new FormControl(),
      country: new FormControl(),
      region: new FormControl(),
      localizationName: new FormControl(),
      zipCode: new FormControl(),
      content: new FormControl()
    });
  }

  submitForm(value: { userName: string; email: string; password: string; confirm: string; comment: string }): void {
    for (const key in this.validateForm.controls) {
      this.validateForm.controls[key].markAsDirty();
      this.validateForm.controls[key].updateValueAndValidity();
    }
    this.modifyOffer(this.offer.id, value);
    this.isVisible = false;
  }

  saveNewData(): void {
    this.submitForm(this.validateForm.value)
    this.modal.close();
  }

  closeModal(): void {
    this.modal.destroy();
  }

}
