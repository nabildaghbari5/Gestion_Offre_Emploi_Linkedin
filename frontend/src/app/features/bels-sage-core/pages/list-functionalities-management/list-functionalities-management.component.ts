import {Component, OnInit} from '@angular/core';
import {TranslateService} from "@ngx-translate/core";

@Component({
    selector: 'app-list-functionalities-management',
    templateUrl: './list-functionalities-management.component.html',
    styleUrls: ['./list-functionalities-management.component.scss']
})
export class ListFunctionalitiesManagementComponent implements OnInit {
    title = "";
    displayedColumns: string[] = ["name", "code", "Actions"];
    fields = ['name', 'code'];
    dataSource: any[] = [];

    constructor(
        private translate: TranslateService) {
    }

    ngOnInit() {
    }

}
