import { CargoService } from '../cargo.service';
import { Cargo } from '../cargo';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cargo-create',
  templateUrl: './cargo-create.component.html',
  styleUrls: ['./cargo-create.component.css']
})
export class CargoCreateComponent implements OnInit {

  employee: Cargo = new Cargo();
  submitted = false;

  constructor(private cargoService: CargoService,
    private router: Router) { }

  ngOnInit() {
  }

  newCargo(): void {
    this.submitted = false;
    this.cargo = new Cargo();
  }

  save() {
    this.cargoService.cargoCreate(this.cargo)
      .subscribe(data => console.log(data), error => console.log(error));
    this.cargo = new Cargo();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/cargos']);
  }
}
