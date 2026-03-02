import {Component, OnInit} from '@angular/core';
import {CountryService} from "../../services/country.service";
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {DialogComponent} from "../../../../shared/components/dialog/dialog.component";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
    selector: 'app-country-management',
    templateUrl: './country-management.component.html',
    styleUrls: ['./country-management.component.scss']
})
export class CountryManagementComponent implements OnInit {
    public dataSource: any[] = [];
    displayedColumns: string[] = ['Code', 'Description', 'ACTIONS'];
    title = "Countries Management";
    filterForm!: FormGroup;

    constructor(
        private router: Router,
        public dialog: MatDialog,
        private formBuilder: FormBuilder,
        private countryService: CountryService) {

        this.filterForm = this.formBuilder.group({
            codecountry: null,
            countrydescription: null
        });
    }

    ngOnInit() {
        this.getAll();
    }

    getAll() {
        this.countryService.getCountries().subscribe(data => {
            if (data != null)
                this.dataSource = data;
        })
    }

    goToUpdateCountry(country: any) {
        this.router.navigate(['/features/core/update-country', country.codecountry])
    }

    filterCountries() {
        this.countryService.getFilteredCountries(this.filterForm.value).subscribe(res =>
                this.dataSource = res
            , error => {
                this.dialog.open(DialogComponent, {
                    width: '300px',
                    data: {title: "Error", text: "Error occurred while proceeding", error: true}
                });
            })
    }


    deleteCountry(country: any) {

        const dialogRef = this.dialog.open(DialogComponent, {
            width: '300px',
            data: {title: "Are you sure ?", text: "Are you sure you want to delete this item ?", error: false}
        });

        dialogRef.afterClosed().subscribe((response: string) => {
            if (response === 'YES') {
                this.countryService.deleteCountry(country.codecountry).subscribe(res => {
                    this.getAll();
                }, error => {
                    this.dialog.open(DialogComponent, {
                        width: '300px',
                        data: {title: "Error", text: "Error occurred while proceeding"}
                    });
                })
            }
        });
    }


}
