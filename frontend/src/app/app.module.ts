import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AdvertisementListComponent } from './advertisement/advertisement-list/advertisement-list.component';
import { AdvertisementPanelComponent } from './advertisement/advertisement-list/advertisement-panel/advertisement-panel.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import {NzGridModule, NzIconModule, NzToolTipModule} from "ng-zorro-antd";

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    AdvertisementListComponent,
    AdvertisementPanelComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzGridModule,
    NzIconModule,
    NzToolTipModule
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent]
})
export class AppModule { }
