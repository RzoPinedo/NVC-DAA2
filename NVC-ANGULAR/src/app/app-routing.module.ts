import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CargoDetailsComponent } from './cargo-details/cargo-details.component';
import { CargoCreateComponent } from './cargo-create/cargo-create.component';
import { CargoListComponent } from './cargo-list/cargo-list.component';
import { CargoUpdateComponent } from './cargo-update/cargo-update.component';
import { EmpleadosDetailsComponent } from './empleados-details/empleados-details.component';
import { EmpleadosCreateComponent } from './empleados-create/empleados-create.component';
import { EmpleadosListComponent } from './empleados-list/empleados-list.component';
import { EmpleadosUpdateComponent } from './empleados-update/empleados-update.component';

const routes: Routes = [
  { path: '', redirectTo: 'cargo', pathMatch: 'full' },
  { path: 'cargo', component: CargoListComponent },
  { path: 'add', component: CargoCreateComponent },
  { path: 'update/:id', component: CargoUpdateComponent },
  { path: 'details/:id', component: CargoDetailsComponent },
  { path: '', redirectTo: 'empleados', pathMatch: 'full' },
  { path: 'empleados', component: EmpleadosListComponent },
  { path: 'add', component: EmpleadosCreateComponent },
  { path: 'update/:id', component: EmpleadosUpdateComponent },
  { path: 'details/:id', component: EmpleadosDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
