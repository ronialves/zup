import { NgModule } from '@angular/core';
import { RouterModule, Routes }  from '@angular/router'
import { HomeComponent } from './home/home.component';
import { CatalogListComponent } from './catalog/catalog-list/catalog-list.component';
import { CatalogEditComponent } from './catalog/catalog-edit/catalog-edit.component';

const appRoutes: Routes = [
  { path: 'catalogo/novo', component: CatalogEditComponent},
  { path: 'catalogo', component: CatalogListComponent},
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: '**', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
    imports: [
      RouterModule.forRoot(appRoutes)
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {}
