import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Curso } from "../model/curso";
import { CursoService } from "../services/curso.service";

@Component({
  selector: "app-curso-list",
  templateUrl: "./curso-list.component.html",
  styleUrls: ["./curso-list.component.css"],
})
export class CursoListComponent implements OnInit {
  list: Observable<Curso[]>;
  constructor(private cursoService: CursoService) {}

  ngOnInit() {
    this.list = this.cursoService.getCursosList();
  }
}
