import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class CursoService {
  private baseUrl = "http://localhost:8085/NVConsulting/rest/curso/curso";

  constructor(private http: HttpClient) {}

  getCursosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
