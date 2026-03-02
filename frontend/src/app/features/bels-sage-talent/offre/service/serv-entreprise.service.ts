import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServEntrepriseService {

  constructor(private http: HttpClient) { }

  baseUrl(){
    return 'http://localhost:8081/api/service' 
  }

  save(id: number|null, any: any): Observable<any> {
    if(id){
      return this.update(id, any)
    }
    return this.create(any)
  }

  create(any: any): Observable<any> {
    let url = this.baseUrl();
    return this.http.post<any>(url, any);
  }

  update(id: number, any: any): Observable<any> {
    let url = `${this.baseUrl()}/${id}`;
    return this.http.put<any>(url, any);
  }

  importCSV(formData: FormData): Observable<void> {
    let url = this.baseUrl() + '/import';

    let headers = new HttpHeaders();
    headers.append('Content-Type', 'multipart/form-data');
    const options = { headers };

    return this.http.post<void>(url, formData, options);
  }

  findById(id: number): Observable<any> {
    let url = `${this.baseUrl()}/${id}`;
    return this.http.get<any>(url);
  }

  findAll(): Observable<Array<any>> {
    let url = this.baseUrl();
    return this.http.get<Array<any>>(url);
  }


  delete(id: number): Observable<boolean> {
    let url = `${this.baseUrl()}/${id}`;
    return this.http.delete<boolean>(url);
  }
}
