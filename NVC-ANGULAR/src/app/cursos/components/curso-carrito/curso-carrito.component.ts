import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { CarritoService } from "../../services/carrito.service";

@Component({
  selector: "app-curso-carrito",
  templateUrl: "./curso-carrito.component.html",
  styleUrls: ["./curso-carrito.component.css"],
})
export class CursoCarritoComponent implements OnInit {
  constructor(public carritoService: CarritoService, private router: Router) {}

  ngOnInit() {}
  irCarrito() {
    this.router.navigate(["/vercarrito"]);
  }
}
