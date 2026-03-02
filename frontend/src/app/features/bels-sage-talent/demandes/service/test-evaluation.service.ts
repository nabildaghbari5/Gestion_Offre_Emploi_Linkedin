import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestEvaluationService {
  private apiUrl = 'http://localhost:8081/api/evaluation';

  constructor(private http: HttpClient) { }
 
  getQuestions(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/questions`);
  }

  getEvaluationByRequestId(requestId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/request/${requestId}`);
  }

  getEvaluationsByCandidateId(candidateId: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/candidate/${candidateId}`);
  }
  getEvaluationsByCandidateIdAndByRequestId(candidateId: string ,requestId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/request/candidate/${candidateId}/${requestId}`);
  }
  
  submitEvaluation(evaluationData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/submit`, evaluationData);
  }
}