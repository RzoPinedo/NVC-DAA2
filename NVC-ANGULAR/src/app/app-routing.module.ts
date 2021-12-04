import { CargoDetailsComponent } from './cargo-details/cargo-details.component';
import { CargoCreateComponent } from './cargo-create/cargo-create.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CargoListComponent } from './cargo-list/cargo-list.component';
import { CargoUpdateComponent } from './cargo-update/cargo-update.component';

const routes: Routes = [
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'cargos', component: CargoListComponent },
  { path: 'add', component: CargoCreateComponent },
  { path: 'update/:id', component: CargoUpdateComponent },
  { path: 'details/:id', component: CargoDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
