import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class CityService {
  constructor(private http: HttpClient) {}

  getCitiesbyCountry(country: any): Observable<any> {
    return this.http.get<any>(
      `/api/core/city/getCitieslinkedCountry/${country}`
    );
  }

  getAllCities() {
    return this.http.get<any>(`/api/core/city/cityfindall`);
  }

  addCity(data: any) {
    return this.http.post<any>(`/api/core/city/cityCreation`, data);
  }

  updateCity(data: any) {
    return this.http.put<any>(`/api/core/city/update-city`, data);
  }

  getCityById(id: number) {
    return this.http.get<any>(`/api/core/city/get-city/${id}`);
  }

  getFilteredCities(data: any) {
    return this.http.post<any>(`/api/core/city/filter-cities`, data);
  }
  deleteCity(id: number) {
    return this.http.delete<any>(`/api/core/city/delete-city/${id}`);
  }
}
