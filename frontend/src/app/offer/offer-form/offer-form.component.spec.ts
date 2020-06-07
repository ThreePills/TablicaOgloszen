import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferFormComponent } from './offer-form.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {NzModalModule} from "ng-zorro-antd";
import {RouterTestingModule} from "@angular/router/testing";
import {RouterModule} from "@angular/router";

describe('OfferFormComponent', () => {
  let component: OfferFormComponent;
  let fixture: ComponentFixture<OfferFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OfferFormComponent ],
      imports: [ RouterTestingModule, RouterModule, HttpClientTestingModule, NzModalModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
