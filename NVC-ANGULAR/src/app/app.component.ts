import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'NVC-ANGULAR';
  logo:string="assets/imagenes/Logo.jpeg";
  fb:string="assets/imagenes/FB.png";
  tw:string="assets/imagenes/TW.png";
  ig:string="assets/imagenes/IG.png";
  yt:string="assets/imagenes/YT.png";

  /*constructor(private app: AppService, private http: HttpClient, private router: Router) {
    this.app.authenticate(undefined, undefined);
  }
  logout() {
    this.http.post('logout', {}).finally(() => {
        this.app.authenticated = false;
        this.router.navigateByUrl('/login');
    }).subscribe();
  }*/
}
