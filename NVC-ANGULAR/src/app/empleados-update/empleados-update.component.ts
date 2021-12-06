import { Component, OnInit } from '@angular/core';
import { Empleados } from '../empleados';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpleadosService } from '../empleados.service';

@Component({
  selector: 'app-empleados-update',
  templateUrl: './empleados-update.component.html',
  styleUrls: ['./empleados-update.component.css']
})
export class EmpleadosUpdateComponent implements OnInit {

  id: number;
  empleados: Empleados;

  constructor(private route: ActivatedRoute,private router: Router,
    private empleadosService: EmpleadosService) { }

  ngOnInit() {
    this.empleados = new Empleados();

    this.id = this.route.snapshot.params['id'];
    
    this.empleadosService.getEmpleados(this.id)
      .subscribe(data => {
        console.log(data)
        this.empleados = data;
      }, error => console.log(error));
  }

  empleadosUpdate() {
    this.empleadosService.empleadosUpdate(this.id, this.empleados)
      .subscribe(data => console.log(data), error => console.log(error));
    this.empleados = new Empleados();
    this.gotoList();
  }

  onSubmit() {
    this.empleadosUpdate();    
  }

  gotoList() {
    this.router.navigate(['/empleados']);
  }
}
