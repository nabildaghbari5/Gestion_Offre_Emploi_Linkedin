import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class SelectCompanyService {

    constructor(private http: HttpClient) {
    }

    getAllCompanies(): Observable<any> {
        return this.http.get<any>(`/api/core/company/companyfindall`);
    }

}
