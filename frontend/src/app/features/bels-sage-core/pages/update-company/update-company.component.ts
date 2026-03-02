import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CompanyService} from "../../services/company.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    selector: 'app-update-company',
    templateUrl: './update-company.component.html',
    styleUrls: ['./update-company.component.scss']
})
export class UpdateCompanyComponent implements OnInit {

    public formGroup!: FormGroup;
    public typecompanies: string[] = ['Public company', 'Private company', 'Non profit organization'];


    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private companyService: CompanyService,

    ) {
    }

    get address() {
        return this.formGroup.controls['addresscompany'] as FormGroup;
    }

    ngOnInit() {
        const companyId = this.route.snapshot.paramMap.get('id');
        if (companyId) {
            const id = companyId as unknown as number;
            this.companyService.getCompanyById(id).subscribe(company => {
                this.formGroup = this.formBuilder.group({
                    idcompany: company.idcompany,
                    fiscalcodecompany: [company.fiscalcodecompany, Validators.required],
                    namecompany: [company.namecompany, [Validators.required]],
                    typecompany: [null, [Validators.required]],
                    addresscompany: this.formBuilder.group({
                        countryaddress: this.formBuilder.group({
                            codecountry: company.addresscompany.countryaddress.codecountry,
                            countrydescription: company.addresscompany.countryaddress.countrydescription
                        }),
                        cityaddress: this.formBuilder.group({
                            idcity: company.addresscompany.cityaddress.idcity,
                            namecity: company.addresscompany.cityaddress.namecity,
                            countrycity: company.addresscompany.cityaddress.countrycity,
                        }),
                        zipcodeaddress: this.formBuilder.group({
                            idzipcode: company.addresscompany.zipcodeaddress.idzipcode,
                            locationzipcode: company.addresscompany.zipcodeaddress.locationzipcode,
                            codezipcode: company.addresscompany.zipcodeaddress.codezipcode,
                            cityzipcode: company.addresscompany.zipcodeaddress.cityzipcode,
                            countryzipcode: company.addresscompany.zipcodeaddress.countryzipcode,

                        }),
                        buildingnumberaddress: company.addresscompany.buildingnumberaddress
                    }),
                    group: null,
                    associatedgroup: null
                });
                this.setTypeCompany(company.typecompany);
            });
        }
    }

    updateCompany() {
       const company = this.formGroup.value;
        this.convertTypeCompany(company);
        this.companyService.updateCompany(company).subscribe(res =>
            this.router.navigate(['features/core/company-management'])
        )
    }

    setTypeCompany(typecompany: string) {
        let val;
        if (typecompany == "public_company") {
            val = "Public company";
        } else if (typecompany == "private_company") {
           val = "Private company";
        } else {
           val = "Non profit organization";
        }
        this.formGroup.patchValue({
            typecompany: val
        })
    }

    convertTypeCompany(company:any){
        if (company.typecompany == "Public company"){
            company.typecompany= "public_company";
        }
        else if (company.typecompany == "Private company"){
            company.typecompany = "private_company";
        }
        else {
            company.typecompany="Non profit organization";
        }
    }

    selectTypeCompanies() {
        this.typecompanies = ['Public company', 'Private company', 'Non profit organization']
    }
}
