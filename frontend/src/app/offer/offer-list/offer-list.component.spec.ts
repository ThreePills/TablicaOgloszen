import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferListComponent } from './offer-list.component';
import { Offer } from '../model/Offer';
import { RouterTestingModule } from '@angular/router/testing';
import { RouterModule } from '@angular/router';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NzModalModule } from 'ng-zorro-antd';

describe('OfferListComponent', () => {
  let component: OfferListComponent;
  let fixture: ComponentFixture<OfferListComponent>;
  let offers: Offer[];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [OfferListComponent],
      imports: [
        RouterTestingModule,
        RouterModule,
        HttpClientTestingModule,
        NzModalModule,
      ],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

    const contact = {
      email: 'email@example.com',
      phoneNumber: 111111111,
      name: 'Name',
    };

    const localization = {
      country: 'Country',
      region: 'Region',
      zipCode: 'zipCode',
      localizationName: 'localizationName',
    };

    const offer1 = {
      contact,
      localization,
      title: 'Title',
      content: 'Content',
    };

    const offer2 = {
      contact,
      localization,
      title: 'Title2',
      content: 'Content2',
    };
    offers = [offer1, offer2];
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should be two offers', () => {
    expect(offers.length).toBe(2);
  });
});
