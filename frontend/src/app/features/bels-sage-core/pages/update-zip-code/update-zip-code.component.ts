import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CityService} from "../../services/city.service";
import {CountryService} from "../../services/country.service";
import {ZipCodeService} from "../../services/zip-code.service";

@Component({
    selector: 'app-update-zip-code',
    templateUrl: './update-zip-code.component.html',
    styleUrls: ['./update-zip-code.component.scss']
})
export class UpdateZipCodeComponent implements OnInit {

    public formGroup!: FormGroup;
    countries: any[] = [];
    cities: any[] = [];

    //flags
    isCountrySelected = false;

    constructor(
        private router: Router,
        private route: ActivatedRoute,
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
        const zipcodeId = this.route.snapshot.paramMap.get('id');
        if (zipcodeId) {
            const id = zipcodeId as unknown as number;
            this.zipCodeService.getZipcodeById(id).subscribe(zipcode => {
                this.formGroup = this.formBuilder.group({
                    idzipcode: [zipcode.idzipcode, Validators.required],
                    locationzipcode: [zipcode.locationzipcode, Validators.required],
                    codezipcode: [zipcode.codezipcode, [Validators.required]],
                    countryzipcode: [zipcode.countryzipcode, [Validators.required]],
                    cityzipcode: [zipcode.cityzipcode, [Validators.required]]
                })
                this.countries = [zipcode.countryzipcode];
                this.cities = [zipcode.cityzipcode]
            })
        }
    }

    updateZipcode() {
        this.zipCodeService.updateZipcode(this.formGroup.value).subscribe(res => {
            this.router.navigate(['/features/core/zipcode-management'])
        })
    }

    selectCountry() {
        if (!this.isCountrySelected) {
            this.countryService.getCountries().subscribe(
                (res) => {
                    this.countries = res;
                },
                (error) => {
                    console.log(error);
                }
            );
        }
        this.isCountrySelected = true;
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
