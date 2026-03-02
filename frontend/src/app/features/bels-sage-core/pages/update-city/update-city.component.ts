import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CityService} from "../../services/city.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CountryService} from "../../services/country.service";

@Component({
    selector: 'app-update-city',
    templateUrl: './update-city.component.html',
    styleUrls: ['./update-city.component.scss']
})
export class UpdateCityComponent implements OnInit {

    public formGroup!: FormGroup;
    public countries: any;
    isSelected = false;

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private cityService: CityService,
        private countryService: CountryService) {
    }


    ngOnInit() {
        const cityId = this.route.snapshot.paramMap.get('id');
        if (cityId) {
            const id = cityId as unknown as number;
            this.cityService.getCityById(id).subscribe(city => {
                this.formGroup = this.formBuilder.group({
                    idcity: city.idcity,
                    namecity: city.namecity,
                    countrycity: city.countrycity,
                })
                this.countries = [city.countrycity];
            })
        }
    }

    getCountries() {
        if (!this.isSelected) {
            this.countryService.getCountries().subscribe(countries => {
                this.countries = countries;
            })
        }
        this.isSelected = true;
    }

    updateCity() {
        this.cityService.updateCity(this.formGroup.value).subscribe(res =>
            this.router.navigate(['features/core/city-management'])
        )
    }
}
