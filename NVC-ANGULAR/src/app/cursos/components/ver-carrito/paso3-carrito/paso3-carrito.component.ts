import { Component, OnInit } from "@angular/core";
import { CarritoService } from "src/app/cursos/services/carrito.service";
import { CursoService } from "src/app/cursos/services/curso.service";

@Component({
  selector: "app-paso3-carrito",
  templateUrl: "./paso3-carrito.component.html",
  styleUrls: ["./paso3-carrito.component.css"],
})
export class Paso3CarritoComponent implements OnInit {
  constructor(
    private carritoService: CarritoService,
    private cursoService: CursoService
  ) {}
  anios = [];
  ngOnInit() {
    this.loadAños();
  }
  loadAños() {
    this.anios.push("Año");
    for (let año = 2015; año < 2030; año++) {
      this.anios.push(año);
    }
  }

  regresarPaso2() {
    this.carritoService.nroPaso = 2;
  }

  continuarPaso4() {
    const carrito = this.carritoService.obtenerCarritoGuardar();
    this.cursoService.guardarCarrito(carrito).subscribe((x) => {
      this.carritoService.nroPaso = 4;
      this.carritoService.listaCursosComprados = [];
    });
  }
}
