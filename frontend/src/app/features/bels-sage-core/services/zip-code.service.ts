import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class ZipCodeService {

    constructor(private http: HttpClient) {
    }

    getAllZipCodes() {
        return this.http.get<any>(`/api/core/zipcode/get-zipcodes`);
    }

    getZipcodeByCode(zipcode: string){
        return this.http.get<any>(`/api/core//zipcode/get-zipcodeByCode/${zipcode}`);
    }

    getZipcodeById(id: number){
        return this.http.get<any>(`/api/core//zipcode/get-zipcode/${id}`);
    }
    getZipcodeByCity(citycode: number){
        return this.http.get<any>(`/api/core/zipcode/get-zipcodeByCity/${citycode}`);
    }

    addZipCode(data: any)  {
        return this.http.post<any>(`/api/core/zipcode/add-zipcode`, data,);
    }

    updateZipcode(data: any)  {
        return this.http.put<any>(`/api/core/zipcode/update-zipcode`, data);
    }

    getFilteredZipcodes(data: any){
        return this.http.post<any>(`/api/core/zipcode/filter-zipcodes`, data);
    }

    deleteZipcode(id: number) {
        return this.http.delete<any>(`/api/core/zipcode/delete-zipcode/${id}`);
    }
}
