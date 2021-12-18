import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Curso } from "../../model/curso";
import { CarritoService } from "../../services/carrito.service";
import { CursoService } from "../../services/curso.service";

@Component({
  selector: "app-curso-list",
  templateUrl: "./curso-list.component.html",
  styleUrls: ["./curso-list.component.css"],
})
export class CursoListComponent implements OnInit {
  list: Observable<Curso[]>;
  constructor(
    private cursoService: CursoService,
    private carritoService: CarritoService
  ) {}

  ngOnInit() {
    this.list = this.cursoService.getCursosList();
  }

  agregarCurso(curso) {
    this.carritoService.agregarCurso(curso);
  }
}
