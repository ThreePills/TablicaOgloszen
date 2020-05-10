import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Advertisement} from "../model/Advertisement";

@Component({
  selector: 'app-advertisement-form',
  templateUrl: './advertisement-form.component.html',
  styleUrls: ['./advertisement-form.component.css']
})
export class AdvertisementFormComponent implements OnInit {

  advertisementForm;

  @Output() saved = new EventEmitter<Advertisement>();

  // TODO: add advertisement rest service
  constructor() {
  }

  ngOnInit(): void {
    console.log("Form component");
    this.advertisementForm = new FormGroup({
      title: new FormControl('', [Validators.required]),
      telephone: new FormControl('', [Validators.required]),
      content: new FormControl('', [Validators.required, Validators.min(10)]),
    });
  }

  onSubmit(formData) {
    if (this.advertisementForm.valid) {
      //this.advertisementService.save(formData).subscribe((advertisement: Advertisement) => this.changed.emit(advertisement));
      this.saved.emit(formData);

      this.advertisementForm.reset();
    }
  }

  get title() {
    return this.advertisementForm.get('title');
  }

  get telephone() {
    return this.advertisementForm.get('telephone');
  }

  get content() {
    return this.advertisementForm.get('content');
  }

}
