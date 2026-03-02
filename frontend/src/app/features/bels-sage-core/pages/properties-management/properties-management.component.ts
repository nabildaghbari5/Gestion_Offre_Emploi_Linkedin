import {Component, OnInit} from '@angular/core';
import {PropertiesService} from "../../services/properties.service";
import {MatDialog} from "@angular/material/dialog";
import {DialogComponent} from "../../../../shared/components/dialog/dialog.component";
import {EditPopupComponent} from "../../components/edit-popup/edit-popup.component";

@Component({
    selector: 'app-properties-management',
    templateUrl: './properties-management.component.html',
    styleUrls: ['./properties-management.component.scss']
})
export class PropertiesManagementComponent implements OnInit {

    displayedColumns: string[] = ['Property', 'Value', 'Action'];
    dataSource: any;

    constructor(
        public dialog: MatDialog,
        private propertiesService: PropertiesService) {
    }

    ngOnInit() {
        this.getProperties();
    }

    getProperties() {
        this.propertiesService.getAllProperties().subscribe(res => {
            this.dataSource = res;
        })
    }

    openUpdateProperty(property: any) {
        const dialogRef = this.dialog.open(EditPopupComponent, {
            width: '500px',
            data: property
        });

        dialogRef.afterClosed().subscribe((res: any) => {
            if (res != null) {
                this.propertiesService.updateProperty(res).subscribe(res => {
                    this.getProperties()
                }, error => {
                    this.dialog.open(DialogComponent, {
                        width: '300px',
                        data: {title: "Error", text: "Error occurred while proceeding", error: true}
                    });
                })
            }
        })
    }
}
