import { Cargo } from '../cargo';
import { Component, OnInit, Input } from '@angular/core';
import { CargoService } from '../cargo.service';
import { CargoListComponent } from '../cargo-list/cargo-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cargo-details',
  templateUrl: './cargo-details.component.html',
  styleUrls: ['./cargo-details.component.css']
})
export class CargoDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['cargos']);
  }
}
