import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {OfferFormComponent} from "./offer/offer-form/offer-form.component";
import {OfferListResolver} from "./offer/offer-list/offer-list-resolver";
import {OfferListComponent} from "./offer/offer-list/offer-list.component";


const routes: Routes = [
  {
    path: '',
    component: OfferListComponent,
    resolve: {
      offers: OfferListResolver
    }
  },
  {
    path: 'offers/create',
    component: OfferFormComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
