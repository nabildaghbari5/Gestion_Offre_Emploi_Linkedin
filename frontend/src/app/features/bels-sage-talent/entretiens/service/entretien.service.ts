import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EntretienService {

  constructor(private http: HttpClient) { }

  baseUrl(){
    return 'http://localhost:8081/api/entretien' 
  }

 
  create(entretien: any): Observable<any> {
    let url = this.baseUrl();
    return this.http.post<any >(url, entretien);
  }

  

  update(id: number, demande: any): Observable<any> {
    let url = `${this.baseUrl()}/${id}`;
    return this.http.put<any>(url, demande);
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

  findAllByCandidatId(candiatId:string){
    let url = `${this.baseUrl()}/getByCandidatId/${candiatId}`;
    return this.http.get(url);
  }



  findDemandeByStatus():Observable<Array<any>>{
    let url = this.baseUrl() + '/findAllByStatus';
    return this.http.get<Array<any>>(url);
  }

  affectationDemande(demandeId:number , supervisorId:number){
    let url =`${this.baseUrl()}/affectation/AffectaionDemande/${demandeId}/${supervisorId}`;   
    return this.http.put(url , {}) ;   
  }

  findBySuperviseurId(superId:number) {
   let url = `${this.baseUrl()}/getBysuperviseurId/${superId}`;
   return this.http.get(url)
  
  }

  findInternBySuperviseurId(superId:number) {
    let url = `${this.baseUrl()}/interns/bySupervisor/${superId}`;
    return this.http.get(url)
   
   }
  
}
