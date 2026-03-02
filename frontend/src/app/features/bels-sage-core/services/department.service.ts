import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {


  constructor(private http: HttpClient) { }

  getAllDepartments(){
    return this.http.get<any>(`/api/core/department/departmentlist`);
  }

  getDepartmentByCode(code: number){
    return this.http.get<any>(`/api/core/department/departmentconsult/${code}`);
  }
  addDepartment(data: any){
    return this.http.post<any>(`/api/core/department/departmentcreation`, data);
  }

  updateDepartment(department: any){
    return this.http.put<any>(`/api/core/department/departmentupdate`, department);
  }

  deleteDepartment(id: number){
    return this.http.delete<any>(`/api/core/department/departmentdelete/${id}`);
  }

    filterDepartments(data: any) {
       return this.http.post<any>(`/api/core/department/filter-department`, data);
    }
}
