import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Computador } from '../models/computador';
import { Periferico } from '../components/periferico/periferico';

@Injectable({
  providedIn: 'root',
})
export class Listagem {
  private http = inject(HttpClient);

  private API_URL = "http://localhost:8080/api/computador"
  private API_URL_PER = "http://localhost:8080/api/periferico"

 getComputadores(): Observable<any> {
  return this.http.get(this.API_URL);
 }

 createComputador(data: any): Observable<any> {
  return this.http.post(this.API_URL, data);
 }

 findComputadorById(id:number): Observable<any>{
  return this.http.get(`${this.API_URL}/${id}`);
 }

 updateComputador(id:number, body:any): Observable<any>{
  return this.http.put(`${this.API_URL}/${id}`, body);
 }

 deleteComputador(id:number): Observable<any>{
  return this.http.delete(`${this.API_URL}/${id}`);
 }

 createPeriferico(id:number, body:Periferico){
  return this.http.post(`${this.API_URL_PER}/${id}`, body);
 }

 deletePeriferico(idComp: number, idPer: number):Observable<any>{
  return this.http.delete(`${this.API_URL_PER}/${idComp}/${idPer}`);
 }

 updatePeriferico(id: number, body: Periferico): Observable<any> {
  return this.http.put(`${this.API_URL_PER}/${id}`, body);
 }

}
