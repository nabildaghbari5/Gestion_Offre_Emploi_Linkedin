import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CompanyService} from '../../services/company.service';

@Component({
    selector: 'app-add-company',
    templateUrl: './add-company.component.html',
    styleUrls: ['./add-company.component.scss']
})
export class AddCompanyComponent implements OnInit {

    public formGroup: FormGroup;
    @Input() group = false;
    public spinner: boolean = false;
    public typecompanies: string[] = ['Public company', 'Private company', 'Non profit organization'];

    constructor(
        private formBuilder: FormBuilder,
        private service: CompanyService,
        private route: Router,
    ) {
        this.formGroup = this.formBuilder.group({
            fiscalcodecompany: [null, Validators.required],
            namecompany: [null, [Validators.required]],
            typecompany: [null, [Validators.required]],
            addresscompany: this.formBuilder.group({
                countryaddress: this.formBuilder.group({
                    codecountry: [null, Validators.required],
                    countrydescription: [null, Validators.required]
                }),
                cityaddress: this.formBuilder.group({
                    idcity: [null, Validators.required],
                    namecity: [null, Validators.required],
                    countrycity: [null, Validators.required]
                }),
                zipcodeaddress: this.formBuilder.group({
                    idzipcode: [null, Validators.required],
                    locationzipcode: [null, Validators.required],
                    codezipcode: [null, Validators.required],
                    cityzipcode: [null, Validators.required],
                    countryzipcode: [null, Validators.required],

                }),
                buildingnumberaddress: [null, Validators.required]
            }),
            group: [this.group],
            associatedgroup: null
        });
    }

    get f() {
        return this.formGroup.controls;
    }

    get address() {
        return this.f['addresscompany'] as FormGroup;
    }

    ngOnInit(): void {
    }

    convertTypeCompany(company: any) {
        if (company.typecompany == "Public company") {
            company.typecompany = "public_company";
        } else if (company.typecompany == "Private company") {
            company.typecompany = "private_company";
        } else {
            company.typecompany = "Non profit organization";
        }
    }

    onSubmit(company: any) {
        this.spinner = true;
        this.convertTypeCompany(company)

        this.service.addCompany(company).subscribe(
            (res) => {
                this.spinner = false;
                this.route.navigate(['/features/core/company-management']);
            },
            (error) => {
                console.log(error);
                this.spinner = false;
            }
        );
    }
}
