import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {of} from "rxjs";
import {environment} from "../../../../environments/environment.development";

@Injectable({
    providedIn: 'root'
})
export class ProfileService {

    profiles = ["profile1", "profile2"];


    constructor(private http: HttpClient) {
    }

    getAllProfiles() {
        return this.http.get<any>(`/api/core/profile/get-profiles`);
    }


}
