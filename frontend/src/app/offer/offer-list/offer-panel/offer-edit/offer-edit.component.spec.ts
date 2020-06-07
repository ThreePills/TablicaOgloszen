import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferEditComponent } from './offer-edit.component';
import { NzModalService, NzModalRef, NzModalModule } from 'ng-zorro-antd';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

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

const offer = {
  contact,
  localization,
  title: 'Title',
  content: 'Content',
};

describe('OfferEditComponent', () => {
  let component: OfferEditComponent;
  let fixture: ComponentFixture<OfferEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [OfferEditComponent],
      imports: [NzModalModule, BrowserAnimationsModule],
      providers: [
        {
          provide: NzModalRef,
          useFactory: (modalSvc: NzModalService) =>
            modalSvc.create({
              nzClosable: false,
              nzContent: OfferEditComponent,
            }),
          deps: [NzModalService],
        },
      ],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferEditComponent);
    component = fixture.componentInstance;
    component.offer = offer;
    component.ngOnInit();
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
