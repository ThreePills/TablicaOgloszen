import { TestBed } from '@angular/core/testing';

import { OffersRestService } from './offers-rest.service';
import {RouterTestingModule} from "@angular/router/testing";
import {RouterModule} from "@angular/router";
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {NzModalModule} from "ng-zorro-antd";

describe('OffersRestService', () => {
  let service: OffersRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule]});
    service = TestBed.inject(OffersRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
