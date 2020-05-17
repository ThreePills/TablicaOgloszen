import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { OfferListComponent } from './offer/offer-list/offer-list.component';
import { OfferPanelComponent } from './offer/offer-list/offer-panel/offer-panel.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import {
  NzButtonModule,
  NzDropDownModule,
  NzEmptyModule,
  NzGridModule,
  NzIconModule, NzModalModule,
  NzRadioModule,
  NzToolTipModule
} from "ng-zorro-antd";
import {AppRoutingModule} from "./app-routing.module";

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    OfferListComponent,
    OfferPanelComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzGridModule,
    NzIconModule,
    NzToolTipModule,
    NzRadioModule,
    NzButtonModule,
    NzEmptyModule,
    NzDropDownModule,
    NzModalModule
  ],
  providers: [
    { provide: NZ_I18N, useValue: en_US },

    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
