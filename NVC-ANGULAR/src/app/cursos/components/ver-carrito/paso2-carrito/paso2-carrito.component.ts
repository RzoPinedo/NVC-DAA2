import { Component, OnInit } from "@angular/core";
import { CarritoCompraCursos } from "src/app/cursos/model/alumno";
import { CarritoService } from "src/app/cursos/services/carrito.service";

@Component({
  selector: "app-paso2-carrito",
  templateUrl: "./paso2-carrito.component.html",
  styleUrls: ["./paso2-carrito.component.css"],
})
export class Paso2CarritoComponent implements OnInit {
  alumno: CarritoCompraCursos = {};
  constructor(private carritoService: CarritoService) {}
  anios = [];
  ngOnInit() {}

  continuarPaso3() {
    this.carritoService.guardarAlumno(this.alumno);
    this.carritoService.nroPaso = 3;
  }

  regresarPaso1() {
    this.carritoService.nroPaso = 1;
  }
}
