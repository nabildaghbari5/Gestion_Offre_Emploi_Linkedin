import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CityService} from 'src/app/features/bels-sage-core/services/city.service';
import {CountryService} from 'src/app/features/bels-sage-core/services/country.service';
import {ZipCodeService} from "../../../features/bels-sage-core/services/zip-code.service";

@Component({
    selector: 'app-address',
    templateUrl: './address.component.html',
    styleUrls: ['./address.component.scss']
})
export class AddressComponent implements OnInit {

    @Input() addressForm!: FormGroup;

    countries: any[] = [];
    countriesDescription: any[] = [];

    cities: any[] = [];
    citiesDescription: any[] = [];


    constructor(
        private formBuilder: FormBuilder,
        private service: CountryService,
        private serviceCity: CityService,
        private zipcodeService: ZipCodeService) {
    }

    ngOnInit() {
        this.getCountries();
    }

    getCountries() {
        this.service.getCountries().subscribe(
            (res) => {
                this.countries = res;
                this.countriesDescription = this.countries.map(country => country.countrydescription)
                if (this.addressForm.get('countryaddress')?.get('countrydescription')?.value) {
                    this.getCitiesByCountry(this.addressForm.get('countryaddress')?.get('codecountry')?.value)
                }
            },
            (error) => {
                console.log(error);
            }
        );
    }

    selectCountry() {
        //set country
        const description = this.addressForm.get('countryaddress')?.get('countrydescription')?.value;
        const country = this.countries.filter(country => country.countrydescription == description)[0];
        //patch country value
        this.addressForm.patchValue({
            countryaddress: country
        })
        this.getCitiesByCountry(country.codecountry);
    }

    getCitiesByCountry(countryCode: any) {
        this.serviceCity.getCitiesbyCountry(countryCode).subscribe(
            (res) => {
                this.cities = res
                this.citiesDescription = this.cities.map(city => city.namecity);
            },
            (error) => {
                console.log(error);
            }
        );
    }

    selectCity() {
        //set city
        const name = this.addressForm.get('cityaddress')?.get('namecity')?.value;
        const city = this.cities.filter(city => city.namecity == name)[0];
        //patch city value
        this.addressForm.patchValue({
            cityaddress: city
        })
        this.getZipcodeByCity(city.idcity);
    }


    private getZipcodeByCity(idcity: number) {
        this.zipcodeService.getZipcodeByCity(idcity).subscribe(res => {
            this.addressForm.patchValue({
                zipcodeaddress: res
            })
        })
    }
}
