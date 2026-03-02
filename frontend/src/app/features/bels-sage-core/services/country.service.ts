import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor(private http: HttpClient) {
  }

  addCountry(country: any) : Observable<any> {
      return this.http.post<any>(`/api/core/country/countrycreation`, country);
    }

    updateCountry(country: any) : Observable<any> {
        return this.http.put<any>(`/api/core/country/update-country`, country);
    }


    getCountries() : Observable<any> {
      return this.http.get<any>(`/api/core/country/getCountries`);
    }

    getCountryByCode(code: string) : Observable<any> {
        return this.http.get<any>(`/api/core/country/get-country/${code}`);
    }

    getFilteredCountries(data: any){
        return this.http.post<any>(`/api/core/country/filter-countries`, data);
    }
    deleteCountry(id: string) : Observable<any> {
        return this.http.delete<any>(`/api/core/country/delete-country/${id}`);
    }
}
