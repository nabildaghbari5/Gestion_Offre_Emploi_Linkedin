import {Component, OnInit} from '@angular/core';
import {ZipCodeService} from "../../services/zip-code.service";
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {DialogComponent} from "../../../../shared/components/dialog/dialog.component";
import {FormBuilder, FormGroup} from "@angular/forms";
import {CityService} from "../../services/city.service";
import {CountryService} from "../../services/country.service";

@Component({
    selector: 'app-zip-code-management',
    templateUrl: './zip-code-management.component.html',
    styleUrls: ['./zip-code-management.component.scss']
})
export class ZipCodeManagementComponent implements OnInit {
    public dataSource: any[] = [];
    displayedColumns: string[] = ['Code', 'Location', "country", "city", 'ACTIONS'];
    title = "Zipcodes Management";
    filterForm!: FormGroup;
    countries: any[] = [];
    cities: any[] = [];

    constructor(
        private router: Router,
        public dialog: MatDialog,
        private formBuilder: FormBuilder,
        private cityService: CityService,
        private countryService: CountryService,
        private zipCodeService: ZipCodeService) {
        this.filterForm = this.formBuilder.group({
            locationzipcode: null,
            codezipcode: null,
            countryzipcode: null,
            cityzipcode: null
        });
    }

    ngOnInit(): void {
        this.getAll();
        this.getCities();
        this.getCountries();
    }


    getAll(): void {
        this.zipCodeService.getAllZipCodes().subscribe((result: any[]) => {
            this.dataSource = result;
        });
    }

    goToUpdateZipcode(zipcode: any) {
        this.router.navigate(['features/core/update-zipcode', zipcode.idzipcode])

    }

    filterZipcodes() {
        this.zipCodeService.getFilteredZipcodes(this.filterForm.value).subscribe(res => {
            this.dataSource = res

        }, error => {
            this.dialog.open(DialogComponent, {
                width: '300px',
                data: {title: "Error", text: "Error occurred while proceeding", error: true}
            });
        });
    }

    getCountries() {
        this.countryService.getCountries().subscribe(
            (res) => {
                this.countries = res;
            },
            (error) => {
                console.log(error);
            }
        );
    }

    getCities(){
        this.cityService.getAllCities().subscribe(res => {
            this.cities = res;
        })
    }

    selectCountry() {
        this.getCitiesByCountry(this.filterForm.controls['countryzipcode']?.value.codecountry)
    }

    getCitiesByCountry(countryCode: any) {
        this.cityService.getCitiesbyCountry(countryCode).subscribe(
            (res) => {
                this.cities = res
            },
            (error) => {
                console.log(error);
            }
        );
    }

    deleteZipcode(zipcode: any) {

        const dialogRef = this.dialog.open(DialogComponent, {
            width: '300px',
            data: {title: "Are you sure ?", text: "Are you sure you want to delete this item ?", error: false}
        });

        dialogRef.afterClosed().subscribe((response: string) => {
            if (response === 'YES') {
                this.zipCodeService.deleteZipcode(zipcode.idzipcode).subscribe(res => {
                    this.getAll();
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
