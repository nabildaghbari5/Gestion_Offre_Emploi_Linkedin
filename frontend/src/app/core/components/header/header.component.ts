import {Component} from '@angular/core';
import {SideBarService} from "../../services/sideBar.service";
import {TranslateService} from "@ngx-translate/core";
import { KeycloakService } from 'src/app/service/keycloak.service';


@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})
export class HeaderComponent {


    constructor(public sideBarService: SideBarService, 
                 private keycloakService:KeycloakService,
                private translate: TranslateService) {
    }

    changeLanguage(target: any){
        this.translate.use(target.value);
        sessionStorage.setItem("lang", target.value);
    }

    logout(){
        this.keycloakService.logout()
    }
}
