import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Demande } from '../models/demande';

@Injectable({
  providedIn: 'root'
})
export class DemandeService {
 
  constructor(private http: HttpClient) { }

  baseUrl(){
    return 'http://localhost:8081/api/demande' 
  }

 
  create(demande: FormData  , announcementId:number): Observable<Demande> {
    let url = this.baseUrl();
    let params = new HttpParams();
    params =params.append('announcementId' , announcementId)
    return this.http.post<Demande>(url, demande, {params});
  }

  

  update(id: number, demande: Demande): Observable<any> {
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

  updateStatusDemande(demandeId: number, status: string): Observable<Demande> {
    let url = `${this.baseUrl()}/updateStatusDemande/${demandeId}`;
    // Créez un objet qui correspond à la structure attendue par le backend
    const body = { status: status };
    // Assurez-vous que la requête soit envoyée avec le bon 'Content-Type'
    return this.http.put<Demande>(url, body, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json' 
      })
    });
  }

  findDemandeByStatus():Observable<Array<Demande>>{
    let url = this.baseUrl() + '/findAllByStatus';
    return this.http.get<Array<Demande>>(url);
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
