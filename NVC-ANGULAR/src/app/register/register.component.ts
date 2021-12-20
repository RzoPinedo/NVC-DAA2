import { Component } from "@angular/core";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent {
  email: string;
  username: string;
  password: string;
  confirmPassword: string;
  passwordError: boolean;

  constructor() {}

  register() {
    console.log(this.username);
    console.log(this.password);
  }
}