import {Component, OnInit} from '@angular/core';
import {CityService} from "../../services/city.service";
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {DialogComponent} from "../../../../shared/components/dialog/dialog.component";
import {FormBuilder, FormGroup} from "@angular/forms";
import {CountryService} from "../../services/country.service";

@Component({
    selector: 'app-city-management',
    templateUrl: './city-management.component.html',
    styleUrls: ['./city-management.component.scss']
})
export class CityManagementComponent implements OnInit {
    public dataSource: any[] = [];
    displayedColumns: string[] = ['Name', 'Country', 'ACTIONS'];
    filterForm! : FormGroup;
    public countries: any;

    constructor(private router: Router,
                public dialog: MatDialog,
                private formBuilder: FormBuilder,
                private cityService: CityService,
                private countryService: CountryService) {

        this.filterForm = this.formBuilder.group({
            namecity: null,
            countrycity: null
        })
    }

    ngOnInit(): void {
        this.getAllCities();
        this.getCountries();
    }


    getAllCities(): void {
        this.cityService.getAllCities().subscribe((result: any[]) => {
            this.dataSource = result;
        });
    }

    getCountries() {
        this.countryService.getCountries().subscribe(countries => {
            this.countries = countries;
        })
    }

    goToUpdateCity(city: any) {
        this.router.navigate(['features/core/update-city', city.idcity])
    }

    filterCities() {
        this.cityService.getFilteredCities(this.filterForm.value).subscribe(res => {
            this.dataSource = res
        }, error => {
            this.dialog.open(DialogComponent, {
                width: '300px',
                data: {title: "Error", text: "Error occurred while proceeding", error: true}
            });
        })
    }

    deleteCity(city: any) {
        const dialogRef = this.dialog.open(DialogComponent, {
            width: '300px',
            data: {title: "Are you sure ?", text: "Are you sure you want to delete this item ?", error: false}
        });

        dialogRef.afterClosed().subscribe((response: string) => {
            if (response === 'YES') {
                this.cityService.deleteCity(city.idcity).subscribe((res) => {
                    this.getAllCities()
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
