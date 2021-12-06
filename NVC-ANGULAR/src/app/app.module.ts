import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {CargoCreateComponent} from './cargo-create/cargo-create.component';
import { CargoListComponent } from './cargo-list/cargo-list.component';
import { CargoDetailsComponent } from './cargo-details/cargo-details.component';
import { CargoUpdateComponent } from './cargo-update/cargo-update.component';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    CargoCreateComponent,
    CargoCreateComponent,
    CargoDetailsComponent,
    CargoUpdateComponent,
    CargoListComponent
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
