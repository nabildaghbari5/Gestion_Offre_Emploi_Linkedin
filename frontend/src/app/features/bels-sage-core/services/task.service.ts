import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class TaskService {

    constructor(private http: HttpClient) {
    }

    getAllTasks(): Observable<any> {
        return this.http.get<any>(`/api/core/task/listAlltasks`);
    }

    getTaskById(id: number) {
        return this.http.get<any>(`/api/core/task/get-task/${id}`);
    }

    addTask(task: any): Observable<any> {
        return this.http.post<any>(`/api/core/task/taskcreation`, task);
    }

    updateTask(task: any): Observable<any> {
        return this.http.put<any>(`/api/core/task/taskupdate`, task);
    }

    deleteTask(id: number) {
        return this.http.delete<any>(`/api/core/task/taskdelete/${id}`);
    }

    filterTasks(data: any) {
        return this.http.post<any>(`/api/core/task/filter-task`, data);
    }
}
