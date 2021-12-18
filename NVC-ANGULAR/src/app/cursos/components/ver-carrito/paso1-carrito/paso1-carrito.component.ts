import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Curso } from "src/app/cursos/model/curso";
import { CarritoService } from "src/app/cursos/services/carrito.service";

@Component({
  selector: "app-paso1-carrito",
  templateUrl: "./paso1-carrito.component.html",
  styleUrls: ["./paso1-carrito.component.css"],
})
export class Paso1CarritoComponent implements OnInit {
  cursos: Curso[] = [];

  constructor(private router: Router, private carritoService: CarritoService) {}

  ngOnInit() {
    this.cursos = this.carritoService.listaCursosComprados;
  }
  continuarComprando() {
    this.router.navigate(["/cursos"]);
  }
  eliminarCursoCarrito(curso: Curso) {
    this.carritoService.eliminarCurso(curso.id_CURSOS);
    this.cursos = this.carritoService.listaCursosComprados;
  }

  continuarPaso2() {
    this.carritoService.nroPaso = 2;
  }
  continuarPaso3() {
    this.carritoService.nroPaso = 3;
  }

  regresarPaso1() {
    this.carritoService.nroPaso = 1;
  }

  get totalPagar() {
    let total = 0;
    for (const curso of this.cursos) {
      total += curso.precio_CURSO;
    }
    return total;
  }
}
