import { Component, OnInit } from '@angular/core';
import { Cargo } from '../cargo';
import { ActivatedRoute, Router } from '@angular/router';
import { CargoService } from '../cargo.service';

@Component({
  selector: 'app-cargo-update',
  templateUrl: './cargo-update.component.html',
  styleUrls: ['./cargo-update.component.css']
})
export class CargoUpdateComponent implements OnInit {

  id: number;
  cargo: Cargo;

  constructor(private route: ActivatedRoute,private router: Router,
    private cargoService: CargoService) { }

  ngOnInit() {
    this.cargo = new Cargo();

    this.id = this.route.snapshot.params['id'];
    
    this.cargoService.getCargo(this.id)
      .subscribe(data => {
        console.log(data)
        this.cargo = data;
      }, error => console.log(error));
  }

  cargoUpdate() {
    this.cargoService.cargoUpdate(this.id, this.cargo)
      .subscribe(data => console.log(data), error => console.log(error));
    this.cargo = new Cargo();
    this.gotoList();
  }

  onSubmit() {
    this.cargoUpdate();    
  }

  gotoList() {
    this.router.navigate(['/cargos']);
  }
}
