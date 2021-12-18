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
import { CursoListComponent } from "./cursos/components/curso-list/curso-list.component";
import { CursoCarritoComponent } from "./cursos/components/curso-carrito/curso-carrito.component";
import { VerCarritoComponent } from "./cursos/components/ver-carrito/ver-carrito.component";
import { MatDialogModule } from "@angular/material/dialog";
import { PasarelaPagoComponent } from "./cursos/components/pasarela-pago/pasarela-pago.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { Paso1CarritoComponent } from './cursos/components/ver-carrito/paso1-carrito/paso1-carrito.component';
import { Paso2CarritoComponent } from './cursos/components/ver-carrito/paso2-carrito/paso2-carrito.component';
import { Paso3CarritoComponent } from './cursos/components/ver-carrito/paso3-carrito/paso3-carrito.component';
import { Paso4CarritoComponent } from './cursos/components/ver-carrito/paso4-carrito/paso4-carrito.component';

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
    CursoCarritoComponent,
    VerCarritoComponent,
    PasarelaPagoComponent,
    Paso1CarritoComponent,
    Paso2CarritoComponent,
    Paso3CarritoComponent,
    Paso4CarritoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatDialogModule,
  ],
  entryComponents: [PasarelaPagoComponent],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
