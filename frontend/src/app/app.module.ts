import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { OfferListComponent } from './offer/offer-list/offer-list.component';
import { OfferPanelComponent } from './offer/offer-list/offer-panel/offer-panel.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import {NzButtonModule, NzGridModule, NzIconModule, NzRadioModule, NzToolTipModule} from "ng-zorro-antd";
import { OfferFormComponent } from './offer/offer-form/offer-form.component';
import {AppRoutingModule} from "./app-routing.module";

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    OfferListComponent,
    OfferPanelComponent,
    OfferFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzGridModule,
    NzIconModule,
    NzToolTipModule,
    NzRadioModule,
    NzButtonModule,
    ReactiveFormsModule,
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent]
})
export class AppModule { }
