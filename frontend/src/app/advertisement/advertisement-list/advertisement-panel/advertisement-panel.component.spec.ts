import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvertisementPanelComponent } from './advertisement-panel.component';

describe('AdvertisementPanelComponent', () => {
  let component: AdvertisementPanelComponent;
  let fixture: ComponentFixture<AdvertisementPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvertisementPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvertisementPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
