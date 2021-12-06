import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CargoService {

  private baseUrl = 'http://localhost:8085/NVConsulting/rest/cargo/cargos';

  constructor(private http: HttpClient) { }

  getCargo(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  cargoCreate(cargo: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, cargo);
  }

  cargoUpdate(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  cargoDelete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getCargoList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
