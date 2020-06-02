import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
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
import {
  NzButtonModule,
  NzEmptyModule,
  NzModalModule,
  NzDropDownModule,
  NzGridModule,
  NzIconModule,
  NzRadioModule,
  NzToolTipModule,
  NzInputModule, NzFormModule, NzSelectModule
} from "ng-zorro-antd";
import { OfferFormComponent } from './offer/offer-form/offer-form.component';
import {AppRoutingModule} from "./app-routing.module";
import {FilterlistTitle} from "./offer/offer-list/filterListTitle";
import {MatListModule} from "@angular/material/list";
import {FilterlistCity} from "./offer/offer-list/filterListCity";
import { OfferEditComponent } from './offer/offer-list/offer-panel/offer-edit/offer-edit.component';
import {SpinnerLoaderComponent} from "./spinner-loader/spinner-loader.component";

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    OfferListComponent,
    OfferPanelComponent,
    OfferFormComponent,
    FilterlistTitle,
    FilterlistCity,
    OfferEditComponent,
    SpinnerLoaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzGridModule,
    NzIconModule,
    NzToolTipModule,
    NzRadioModule,
    NzButtonModule,
    ReactiveFormsModule,
    NzButtonModule,
    NzEmptyModule,
    NzDropDownModule,
    NzModalModule,
    MatListModule,
    NzInputModule,
    NzFormModule,
    NzSelectModule
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent]
})
export class AppModule { }
