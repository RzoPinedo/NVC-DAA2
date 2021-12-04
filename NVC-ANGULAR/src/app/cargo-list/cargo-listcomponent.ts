import { CargoDetailsComponent } from './../cargo-details/cargo-details.component';
import { Observable } from "rxjs";
import { CargoService } from "./../cargo.service";
import { Cargo } from "./../cargo";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-cargo-list",
  templateUrl: "./cargo-list.component.html",
  styleUrls: ["./cargo-list.component.css"]
})
export class CargoListComponent implements OnInit {
  cargo: Observable<Cargo[]>;

  constructor(private cargoService: CargoService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.cargo = this.cargoService.getCargoList();
  }

  cargoDelete(id: number) {
    this.cargoService.cargoDelete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  cargoDetails(id: number){
    this.router.navigate(['details', id]);
  }

  cargoUpdate(id: number){
    this.router.navigate(['update', id]);
  }
}
