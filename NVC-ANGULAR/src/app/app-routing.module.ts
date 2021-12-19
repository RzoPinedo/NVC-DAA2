import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { CargoDetailsComponent } from "./cargo-details/cargo-details.component";
import { CargoCreateComponent } from "./cargo-create/cargo-create.component";
import { CargoListComponent } from "./cargo-list/cargo-list.component";
import { CargoUpdateComponent } from "./cargo-update/cargo-update.component";
import { EmpleadosDetailsComponent } from "./empleados-details/empleados-details.component";
import { EmpleadosCreateComponent } from "./empleados-create/empleados-create.component";
import { EmpleadosListComponent } from "./empleados-list/empleados-list.component";
import { EmpleadosUpdateComponent } from "./empleados-update/empleados-update.component";
import { CursoListComponent } from "./cursos/components/curso-list/curso-list.component";
import { VerCarritoComponent } from "./cursos/components/ver-carrito/ver-carrito.component";
import { AppComponent } from "./app.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { PrincipalComponent } from "./principal/principal.component";
import { NosotrosComponent } from "./nosotros/nosotros.component";
import { ContactoComponent } from "./contacto/contacto.component";
import { AyudaComponent } from "./ayuda/ayuda.component";


const routes: Routes = [
  { path: "", redirectTo: "principal", pathMatch: "full" },
  { path: "principal", component: PrincipalComponent },
  { path: "cargo", component: CargoListComponent },
  { path: "add", component: CargoCreateComponent },
  { path: "update/:id", component: CargoUpdateComponent },
  { path: "details/:id", component: CargoDetailsComponent },
  { path: "", redirectTo: "empleados", pathMatch: "full" },
  { path: "empleados", component: EmpleadosListComponent },
  { path: "addemp", component: EmpleadosCreateComponent },
  { path: "updateEmp/:id", component: EmpleadosUpdateComponent },
  { path: "detailsEmp/:id", component: EmpleadosDetailsComponent },
  { path: "cursos", component: CursoListComponent },
  { path: "vercarrito", component: VerCarritoComponent },
  { path: "", component: AppComponent, pathMatch: "full" },
  { path: "login", component: LoginComponent, pathMatch: "full" },
  { path: "register", component: RegisterComponent, pathMatch: "full"},
  { path: "nosotros", component: NosotrosComponent },
  { path: "contacto", component: ContactoComponent },
  { path: "ayuda", component: AyudaComponent },  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
/*export const routing = RouterModule.forRoot(appRoutes);*/
