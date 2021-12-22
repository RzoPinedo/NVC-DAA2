import { Component, OnInit } from "@angular/core";
import { MatDialog, MatDialogConfig } from "@angular/material/dialog";
import { Router } from "@angular/router";
import { Curso } from "../../model/curso";
import { CarritoService } from "../../services/carrito.service";
import { PasarelaPagoComponent } from "../pasarela-pago/pasarela-pago.component";

@Component({
  selector: "app-ver-carrito",
  templateUrl: "./ver-carrito.component.html",
  styleUrls: ["./ver-carrito.component.css"],
})
export class VerCarritoComponent implements OnInit {
  cursos: Curso[] = [];
  //nroPaso: number = 1;
  constructor(private router: Router, public carritoService: CarritoService) {}

  ngOnInit() {
    this.carritoService.nroPaso = 1;
    this.cursos = this.carritoService.listaCursosComprados;
  }
}
