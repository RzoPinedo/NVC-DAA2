import { EmpleadosService } from '../empleados.service';
import { Empleados } from '../empleados';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-empleados-create',
  templateUrl: './empleados-create.component.html',
  styleUrls: ['./empleados-create.component.css']
})
export class EmpleadosCreateComponent implements OnInit {

  empleados: Empleados = new Empleados();
  submitted = false;

  constructor(private empleadosService: EmpleadosService,
    private router: Router) { }

  ngOnInit() {
  }

  newEmpleados(): void {
    this.submitted = false;
    this.empleados = new Empleados();
  }

  save() {
    this.empleadosService.empleadosCreate(this.empleados)
      .subscribe(data => console.log(data), error => console.log(error));
    this.empleados = new Empleados();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/empleados']);
  }
}
