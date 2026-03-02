import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class EmployeeService {

    constructor( private http: HttpClient) {
    }

    addEmployee(company: any): Observable<any> {
        return this.http.post<any>(`/api/core/employee/employeecreation`, company);
    }

    updateEmployee(employee: any): Observable<any> {
        return this.http.put<any>(`/api/core/employee/employeeupdate`, employee);
    }

    getEmployeeById(id: number) {
        return this.http.get<any>(`/api/core/employee/employeefind${id}`);
    }

    getAllEmployees(): Observable<any> {
        return this.http.get<any>(`/api/core/employee/employeefindall`);
    }

    getManagers() {
        return this.http.get<any>(`/api/core/employee/employeefindManagers`);
    }

    filteremployee(criteria: any) {
        return this.http.post<any>(`/api/core/employee/filterEmployee`, criteria);
    }

    deleteEmployee(id: number) {
        return this.http.delete<any>(`/api/core/employee/employeedelete${id}`);
    }
}
