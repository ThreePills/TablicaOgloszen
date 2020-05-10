import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdvertisementListComponent} from "./advertisement/advertisement-list/advertisement-list.component";
import {AdvertisementFormComponent} from "./advertisement/advertisement-form/advertisement-form.component";


const routes: Routes = [
  {
    path: '',
    component: AdvertisementListComponent,
  },
  {
    path: 'advertisements/create',
    component: AdvertisementFormComponent,
  },
  // {path: '', redirectTo: 'advertisements', pathMatch: 'full'},
  {path: '**', component: AdvertisementListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
