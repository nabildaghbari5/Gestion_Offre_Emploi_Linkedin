import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DashboardStats } from '../model/dashboard';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private readonly API_URL = 'http://localhost:8081/api/dashboard';

  constructor(private http: HttpClient) {}

  getDashboardStats(): Observable<DashboardStats> {
      return this.http.get<DashboardStats>(`${this.API_URL}/stats`);
  }
}
