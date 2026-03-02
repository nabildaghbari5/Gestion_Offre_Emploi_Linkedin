import {Injectable} from '@angular/core';
import Keycloak from 'keycloak-js';
import { environment } from 'src/environments/environment.development';
import { UserProfile } from './user-ptofile';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class KeycloakService {
  private _keycloak: Keycloak | undefined;

  constructor(private router:Router){

  }

  get keycloak() {
    if (!this._keycloak) {
      this._keycloak = new Keycloak({
        url: environment.keycloak.issuer,
        realm: 'belssage',
        clientId: 'BELSAGEHRFRONT'  
      });
    }
    return this._keycloak;
  }

  private _profile: UserProfile | undefined;

  get profile(): UserProfile | undefined {
    return this._profile;
  }

  async init() {
    const authenticated = await this.keycloak.init({
      onLoad: 'login-required',  
    });    

    if (authenticated) {
      this._profile = (await this.keycloak.loadUserProfile()) as UserProfile;
      this._profile.token = this.keycloak.token || '';
      if (this.keycloak.hasResourceRole('RH')) {
        localStorage.setItem("userProfile", JSON.stringify({
          userRole:"RH",  
        }))
        this.router.navigate(['/features/talent/dashboard/statistique']);
     } else if(this.keycloak.hasResourceRole('Candidat')){  
       localStorage.setItem("userProfile", JSON.stringify({
         userRole:"Candidat",
         id:this._profile.id
       }))
      this.router.navigate(['/features/talent/offre/Announcement_Actuel']);
     }
     else {
        console.log('L\'utilisateur n\'a pas le rôle .');
     }

    }
  }



  login() {
    return this.keycloak.login();
  }

  logout() {
    return this.keycloak.logout({redirectUri: 'http://localhost:4850'});
  }
}