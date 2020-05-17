import { TestBed } from '@angular/core/testing';

import { OffersRestService } from './offers-rest.service';

describe('OffersRestService', () => {
  let service: OffersRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OffersRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
