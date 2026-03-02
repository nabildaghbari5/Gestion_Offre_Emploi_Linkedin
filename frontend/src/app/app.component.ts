import {Component} from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {SideBarService} from "./core/services/sideBar.service";


@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {
    title = 'BelsSageHR';


    constructor(private translate: TranslateService) {
        const lang = sessionStorage.getItem("lang");
        if (lang) {
            this.translate.use(lang);
        } else {
            const browserLang = translate.getBrowserLang()
            browserLang ? this.translate.use(browserLang) : this.translate.use('en')
        }
    }
}
