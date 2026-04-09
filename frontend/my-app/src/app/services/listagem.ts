import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Listagem {
  private http = inject(HttpClient);

  private API_URL = "http://localhost:8080/api/computador"

 getComputadores(): Observable<any> {
  return this.http.get(this.API_URL);
 }
}
