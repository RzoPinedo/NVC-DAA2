import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CargoCreateComponent } from './cargo-create/cargo-create.component';
import { CargoDetailsComponent } from './cargo-details/cargo-details.component';
import { CargoListComponent } from './cargo-list/cargo-list.component';
import { HttpClientModule } from '@angular/common/http';
import { CargoUpdateComponent } from './cargo-update/cargo-update.component';
@NgModule({
  declarations: [
    AppComponent,
    CargoCreateComponent,
    CargoDetailsComponent,
    CargoListComponent,
    CargoUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
