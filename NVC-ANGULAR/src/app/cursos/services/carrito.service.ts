import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Curso } from "../model/curso";
import { CarritoCompraCursos } from "../model/alumno";

@Injectable({
  providedIn: "root",
})
export class CarritoService {
  listaCursosComprados: Curso[] = [];
  nroPaso: number = 1;
  carritoCompraCursos: CarritoCompraCursos = {};
  agregarCurso(curso) {
    this.listaCursosComprados.push(curso);
  }

  eliminarCurso(id_CURSOS) {
    this.listaCursosComprados = this.listaCursosComprados.filter(
      (x) => x.id_CURSOS !== id_CURSOS
    );
  }
  guardarAlumno(carritoCompraCursos) {
    this.carritoCompraCursos = carritoCompraCursos;
  }
  obtenerCarritoGuardar() {
    this.carritoCompraCursos.cursos = this.listaCursosComprados.map(
      (x) => x.id_CURSOS
    );
    return this.carritoCompraCursos;
  }
}
