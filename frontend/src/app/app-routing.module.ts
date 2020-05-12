import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {OfferFormComponent} from "./offer/offer-form/offer-form.component";
import {OfferListComponent} from "./offer/offer-list/offer-list.component";


const routes: Routes = [
  {
    path: '',
    component: OfferListComponent,
  },
  {
    path: 'offers/create',
    component: OfferFormComponent,
  },
  {path: '**', component: OfferListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
