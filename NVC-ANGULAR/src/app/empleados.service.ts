import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {

  private baseUrl = 'http://localhost:8085/NVConsulting/rest/empleados/empleados';

  constructor(private http: HttpClient) { }

  getEmpleados(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  empleadosCreate(empleados: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, empleados);
  }

  empleadosUpdate(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  empleadosDelete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmpleadosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
