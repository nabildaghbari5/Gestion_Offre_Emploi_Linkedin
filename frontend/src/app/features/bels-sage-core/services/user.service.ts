import {Injectable} from '@angular/core';
import {Observable, first, lastValueFrom, map} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class UserService {

    constructor(private http: HttpClient) {
    }


    getAllUsers() {
        return this.http.get<any>(`/api/core/user/get-users`);
    }

    getUserById(id: number) {
        return this.http.get<any>(`/api/core/user/get-user/${id}`);
    }

    addUser(user: any): Observable<any> {
        return this.http.post<any>(`/api/core/user/add-user`, user);
    }

    updateUser(user: any): Observable<any> {
        return this.http.put<any>(`/api/core/user/update-user`, user);
    }

    enableDisable(user: any): Observable<any> {
        return this.http.patch<any>(`/api/core/user/enable-disable`, user);
    }

    deleteUser(id: string): Observable<any> {
        return this.http.delete<any>(`/api/core/user/delete-user/${id}`);
    }

    isHumanResourceManagerGroup(): Observable<boolean> {
        return this.http.get<boolean>('/api/core/user/isHumanRessourceManagerGroup');
    }

    async isGroupHRManager(): Promise<boolean> {
        return lastValueFrom(this.isHumanResourceManagerGroup().pipe(
            first(),
            map(position => position)
        ));
    }

    filterUsers(data: any) {
        return this.http.post<any>(`/api/core/user/filter-users`, data);
    }
}
