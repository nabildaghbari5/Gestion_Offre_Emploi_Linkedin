import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CountryService} from "../../services/country.service";

@Component({
    selector: 'app-update-country',
    templateUrl: './update-country.component.html',
    styleUrls: ['./update-country.component.scss']
})
export class UpdateCountryComponent implements OnInit{

    public formGroup!: FormGroup;

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private service: CountryService,
        private formBuilder: FormBuilder,
    ) {

    }

    ngOnInit() {
        const code = this.route.snapshot.paramMap.get('code');
        if (code) {
            this.service.getCountryByCode(code).subscribe(country => {
                this.formGroup = this.formBuilder.group({
                    codecountry: [country.codecountry, Validators.required],
                    countrydescription: [country.countrydescription, [Validators.required]],
                })
            })
        }
    }

    updateCountry() {
        this.service.updateCountry(this.formGroup.value).subscribe(res => {
            this.router.navigate(['/features/core/country-management']);
        }, error => {
            console.log(error)
        })
    }

}
