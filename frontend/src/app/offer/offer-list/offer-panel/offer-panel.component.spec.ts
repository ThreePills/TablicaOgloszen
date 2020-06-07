import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferPanelComponent } from './offer-panel.component';
import { NzDropDownModule, NzModalModule } from 'ng-zorro-antd';
import { Offer } from '../../model/Offer';

describe('OfferPanelComponent', () => {
  let component: OfferPanelComponent;
  let fixture: ComponentFixture<OfferPanelComponent>;
  let offer: Offer;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [OfferPanelComponent],
      imports: [NzModalModule, NzDropDownModule],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferPanelComponent);
    component = fixture.componentInstance;

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

    offer = {
      contact,
      localization,
      title: 'Title',
      content: 'Content',
    };

    component.offer = offer;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
