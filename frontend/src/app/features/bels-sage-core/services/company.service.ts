import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class CompanyService {

    constructor( private http: HttpClient) {
    }

    addCompany(company: any): Observable<any> {
        return this.http.post<any>(`/api/core/company/companycreation`, company);
    }


    updateCompany(company: any): Observable<any> {
        return this.http.put<any>(`/api/core/company/update-company`, company);
    }

    getAllCompanies(): Observable<any> {
        return this.http.get<any>(`/api/core/company/companyfindall`);
    }

    getCompanyById(id: number) {
        return this.http.get<any>(`/api/core/company/companyfindbyid/${id}`);
    }


    getFilteredCompanies(data: any){
        return this.http.post<any>(`/api/core/company/filter-companies`, data);
    }
    deleteCompany(id: number) {
        return this.http.delete<any>(`/api/core/company/companydelete/${id}`);
    }

    visualizeGroupOrganization(id: number) {
        return this.http.get<any[]>(`/api/core/company/visualizeGroupOrganization/${id}`);
    }
}
