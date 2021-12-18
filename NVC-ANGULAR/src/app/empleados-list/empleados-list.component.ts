import { EmpleadosDetailsComponent } from '../empleados-details/empleados-details.component';
import { Observable } from "rxjs";
import { EmpleadosService } from "../empleados.service";
import { Empleados } from "../empleados";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-empleados-list",
  templateUrl: "./empleados-list.component.html",
  styleUrls: ["./empleados-list.component.css"]
})
export class EmpleadosListComponent implements OnInit {
  empleados: Observable<Empleados[]>;

  constructor(private empleadosService: EmpleadosService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.empleados = this.empleadosService.getEmpleadosList();
  }

  empleadosDelete(id: number) {
    this.empleadosService.empleadosDelete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  empleadosDetails(id: number){
    this.router.navigate(['detailsEmp', id]);
  }

  empleadosUpdate(id: number){
    this.router.navigate(['updateEmp', id]);
  }
}
