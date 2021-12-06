import { Empleados } from '../empleados';
import { Component, OnInit, Input } from '@angular/core';
import { EmpleadosService } from '../empleados.service';
import { EmpleadosListComponent } from '../empleados-list/empleados-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-empleados-details',
  templateUrl: './empleados-details.component.html',
  styleUrls: ['./empleados-details.component.css']
})
export class EmpleadosDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['empleados']);
  }
}
