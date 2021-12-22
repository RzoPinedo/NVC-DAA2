import { Component, OnInit } from "@angular/core";
import { MatDialogRef } from "@angular/material";

@Component({
  selector: "app-pasarela-pago",
  templateUrl: "./pasarela-pago.component.html",
  styleUrls: ["./pasarela-pago.component.css"],
})
export class PasarelaPagoComponent implements OnInit {
  constructor(public dialogRef: MatDialogRef<PasarelaPagoComponent>) {}

  ngOnInit() {}
}
