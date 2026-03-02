import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {DepartmentService} from "../../services/department.service";
import {Router} from "@angular/router";
import {EmployeeService} from "../../services/employee.service";


@Component({
    selector: 'app-add-department',
    templateUrl: './add-department.component.html',
    styleUrls: ['./add-department.component.scss']
})
export class AddDepartmentComponent {

    public formGroup: FormGroup;
    public managers: any[] = [];

    constructor(
        private router: Router,
        private formBuilder: FormBuilder,
        private depService: DepartmentService,
        private employeeService: EmployeeService
    ) {
        this.formGroup = this.formBuilder.group({
            namedepartment: [null, Validators.required],
            codedept: [null, [Validators.required]],
            managerdepartement: [null, [Validators.required]],
            addressedepartment: this.formBuilder.group({
                countryaddress: this.formBuilder.group({
                    codecountry: [null, [Validators.required]],
                    countrydescription: [null, [Validators.required]],
                }),
                cityaddress: this.formBuilder.group({
                    idcity: [null, [Validators.required]],
                    namecity: [null, [Validators.required]],
                    countrycity: [null, [Validators.required]],
                }),
                zipcodeaddress: this.formBuilder.group({
                    idzipcode: [null, [Validators.required]],
                    locationzipcode: [null, [Validators.required]],
                    codezipcode: [null, [Validators.required]],
                    cityzipcode: [null, [Validators.required]],
                    countryzipcode: [null, [Validators.required]],

                }),
                buildingnumberaddress: [null, [Validators.required]]
            })
        });
        this.getManagers();
    }

    get address() {
        return this.formGroup.get('addressedepartment') as FormGroup;
    }

    addDepartment() {
        this.depService.addDepartment(this.formGroup.value).subscribe(res => {
            console.log(res)
            this.router.navigate(['/features/core/department-management']);

        })
    }
    private getManagers() {
        this.employeeService.getManagers().subscribe(res =>
            this.managers = res
        )
    }
}
