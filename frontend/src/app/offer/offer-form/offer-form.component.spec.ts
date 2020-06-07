import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferFormComponent } from './offer-form.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NzModalModule } from 'ng-zorro-antd';
import { RouterTestingModule } from '@angular/router/testing';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

describe('OfferFormComponent', () => {
  let component: OfferFormComponent;
  let fixture: ComponentFixture<OfferFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [OfferFormComponent],
      imports: [
        RouterTestingModule,
        RouterModule,
        HttpClientTestingModule,
        NzModalModule,
        ReactiveFormsModule,
      ],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form invalid when empty', () => {
    expect(component.offerForm.valid).toBeFalsy();
  });

  it('email field validity', () => {
    let errors = {};
    const email = component.email;

    email.setValue('');

    errors = email.errors || {};
    expect(errors['required']).toBeTruthy();

    email.setValue('wrongEmail');

    errors = email.errors || {};
    expect(errors['email']).toBeTruthy();
  });

  it('phoneNumber field validity', () => {
    let errors = {};
    const phoneNumber = component.phoneNumber;
    phoneNumber.setValue();

    errors = phoneNumber.errors || {};
    expect(errors['required']).toBeTruthy();

    phoneNumber.setValue('12345');

    errors = phoneNumber.errors || {};
    expect(errors['minlength']).toBeTruthy();

    phoneNumber.setValue('12345678912');

    errors = phoneNumber.errors || {};
    expect(errors['maxlength']).toBeTruthy();
  });

  it('submitting a form', () => {
    expect(component.offerForm.valid).toBeFalsy();
    component.title.setValue('Title');
    component.content.setValue('Lorem Ipsum Dolor');
    component.name.setValue('Lorem');
    component.email.setValue('Lorem@ipsum.com');
    component.phoneNumber.setValue('12345678');
    component.country.setValue('Poland');
    component.region.setValue('Poland');
    component.zipCode.setValue('50-266');
    component.localizationName.setValue(component.cities.WROCLAW);
    expect(component.offerForm.valid).toBeTruthy();
  });
});
