import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HttpClientModule } from "@angular/common/http";
import { CargoCreateComponent } from "./cargo-create/cargo-create.component";
import { CargoDetailsComponent } from "./cargo-details/cargo-details.component";
import { CargoListComponent } from "./cargo-list/cargo-list.component";
import { CargoUpdateComponent } from "./cargo-update/cargo-update.component";
import { EmpleadosCreateComponent } from "./empleados-create/empleados-create.component";
import { EmpleadosDetailsComponent } from "./empleados-details/empleados-details.component";
import { EmpleadosListComponent } from "./empleados-list/empleados-list.component";
import { EmpleadosUpdateComponent } from "./empleados-update/empleados-update.component";
import { CursoListComponent } from "./cursos/curso-list/curso-list.component";
@NgModule({
  declarations: [
    AppComponent,
    CargoCreateComponent,
    CargoDetailsComponent,
    CargoListComponent,
    CargoUpdateComponent,
    EmpleadosCreateComponent,
    EmpleadosDetailsComponent,
    EmpleadosListComponent,
    EmpleadosUpdateComponent,
    CursoListComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
