import {Component} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {SelectCompanyService} from '../../services/selectCompany.service';

@Component({
    selector: 'app-select-company',
    templateUrl: './select-company.component.html',
    styleUrls: ['./select-company.component.scss']
})
export class SelectCompanyComponent {
    public formGroup: FormGroup;
    public companies: any = [];

    constructor(
        private router: Router,
        private formBuilder: FormBuilder,
        private companyservice: SelectCompanyService,
    ) {
        this.formGroup = this.formBuilder.group({
            company: [null, Validators.required],
        });

        this.getCompanies();

    }

    getCompanies() {
        this.companyservice.getAllCompanies().subscribe((result: any[]) =>
            this.companies = result)
    }


    onSubmit() {
        localStorage.setItem("SELECTEDCOMPANY", this.formGroup.controls['company'].value.idcompany)
        this.router.navigate(['/features/core/']);
    }
}
