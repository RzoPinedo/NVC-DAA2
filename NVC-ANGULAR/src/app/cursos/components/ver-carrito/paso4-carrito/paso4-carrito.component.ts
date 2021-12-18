import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { CarritoService } from "src/app/cursos/services/carrito.service";

@Component({
  selector: "app-paso4-carrito",
  templateUrl: "./paso4-carrito.component.html",
  styleUrls: ["./paso4-carrito.component.css"],
})
export class Paso4CarritoComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit() {}

  irInicio() {
    this.router.navigate(["/vercarrito"]);
  }
}
