import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CountryService} from "../../services/country.service";
import {CityService} from "../../services/city.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-add-city',
    templateUrl: './add-city.component.html',
    styleUrls: ['./add-city.component.scss']
})
export class AddCityComponent {

    public formGroup: FormGroup;
    public countries: any;

    constructor(private router: Router,
                private formBuilder: FormBuilder,
                private cityService: CityService,
                private countryService: CountryService,
    ) {
        this.formGroup = this.formBuilder.group({
            namecity: [null, Validators.required],
            countrycity: [null, Validators.required]
        });
        this.getCountries();
    }

    getCountries() {
        this.countryService.getCountries().subscribe(countries => {
            this.countries = countries;
        })
    }

    addCity() {
        this.cityService.addCity(this.formGroup.value).subscribe(res => {
            this.router.navigate(['features/core/city-management'])
        })
    }
}
