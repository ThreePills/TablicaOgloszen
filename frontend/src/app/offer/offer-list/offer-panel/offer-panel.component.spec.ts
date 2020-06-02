import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferPanelComponent } from './offer-panel.component';

describe('OfferPanelComponent', () => {
  let component: OfferPanelComponent;
  let fixture: ComponentFixture<OfferPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [OfferPanelComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
