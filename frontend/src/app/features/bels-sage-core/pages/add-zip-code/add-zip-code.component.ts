import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ZipCodeService} from "../../services/zip-code.service";
import {CountryService} from "../../services/country.service";
import {Router} from "@angular/router";
import {CityService} from "../../services/city.service";

@Component({
    selector: 'app-add-zip-code',
    templateUrl: './add-zip-code.component.html',
    styleUrls: ['./add-zip-code.component.scss']
})
export class AddZipCodeComponent implements OnInit {

    public formGroup: FormGroup;
    countries: any[] = [];
    cities: any[] = [];

    constructor(
        private router: Router,
        private formBuilder: FormBuilder,
        private cityService: CityService,
        private countryService: CountryService,
        private zipCodeService: ZipCodeService,
    ) {
        this.formGroup = this.formBuilder.group({
            locationzipcode: [null, Validators.required],
            codezipcode: [null, [Validators.required]],
            countryzipcode: [null, [Validators.required]],
            cityzipcode: [null, [Validators.required]]
        });
    }

    ngOnInit() {
        this.getCountries();
    }

    addZipCode() {
        this.zipCodeService.addZipCode(this.formGroup.value).subscribe(res =>
            this.router.navigate(['/features/core/zipcode-management'])
        )
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

    selectCountry() {
        this.getCitiesByCountry(this.formGroup.controls['countryzipcode']?.value.codecountry)
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
}
