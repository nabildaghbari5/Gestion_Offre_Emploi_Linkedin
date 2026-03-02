import {Component} from '@angular/core';
import {SideBarService} from "../../core/services/sideBar.service";

@Component({
    selector: 'app-main',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.scss']
})
export class MainComponent {
    constructor(public toggleService: SideBarService) {
    }

}
