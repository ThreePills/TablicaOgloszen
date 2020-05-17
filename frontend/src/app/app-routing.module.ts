import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {OfferListComponent} from "./offer/offer-list/offer-list.component";
import {OfferListResolver} from "./offer/offer-list/offer-list-resolver";


const routes: Routes = [
  {
    path: '',
    component: OfferListComponent,
    resolve: {
      offers: OfferListResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
