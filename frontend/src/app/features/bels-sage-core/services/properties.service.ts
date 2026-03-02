import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class PropertiesService {

    constructor(private http: HttpClient) {
    }

    getAllProperties(): Observable<any> {
        return this.http.get<any>(`/api/core/property/get-properties`);
    }

    updateProperty(property: any): Observable<any> {
        return this.http.put<any>(`/api/core/property/update-property`, property);
    }
}
