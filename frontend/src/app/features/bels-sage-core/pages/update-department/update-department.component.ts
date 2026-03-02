import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {DepartmentService} from "../../services/department.service";
import {EmployeeService} from "../../services/employee.service";

@Component({
    selector: 'app-update-department',
    templateUrl: './update-department.component.html',
    styleUrls: ['./update-department.component.scss']
})
export class UpdateDepartmentComponent implements OnInit {

    public formGroup!: FormGroup;
    public managers: any[] = [];
    isSelected = false;

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private depService: DepartmentService,
        private employeeService: EmployeeService
    ) {
    }

    get address() {
        return this.formGroup.controls['addressedepartment'] as FormGroup;
    }

    ngOnInit() {
        const depCode = this.route.snapshot.paramMap.get('code');
        if (depCode) {
            const code = depCode as unknown as number;
            this.depService.getDepartmentByCode(code).subscribe(department => {
                this.formGroup = this.formBuilder.group({
                    iddepartment: [department.iddepartment, Validators.required],
                    namedepartment: [department.namedepartment, Validators.required],
                    codedept: [department.codedept, [Validators.required]],
                    managerdepartement: [department.managerdepartement, [Validators.required]],
                    addressedepartment: this.formBuilder.group({
                        countryaddress: this.formBuilder.group({
                            codecountry: department.addressedepartment.countryaddress.codecountry,
                            countrydescription: department.addressedepartment.countryaddress.countrydescription
                        }),
                        cityaddress: this.formBuilder.group({
                            idcity: department.addressedepartment.cityaddress.idcity,
                            namecity: department.addressedepartment.cityaddress.namecity,
                            countrycity: department.addressedepartment.cityaddress.countrycity,
                        }),
                        zipcodeaddress: this.formBuilder.group({
                            idzipcode: department.addressedepartment.zipcodeaddress.idzipcode,
                            locationzipcode: department.addressedepartment.zipcodeaddress.locationzipcode,
                            codezipcode: department.addressedepartment.zipcodeaddress.codezipcode,
                            cityzipcode: department.addressedepartment.zipcodeaddress.cityzipcode,
                            countryzipcode: department.addressedepartment.zipcodeaddress.countryzipcode,

                        }),
                        buildingnumberaddress: department.addressedepartment.buildingnumberaddress
                    })
                });
                this.managers = [department.managerdepartement];
            })
        }
    }

    updateDepartment() {
        this.depService.updateDepartment(this.formGroup.value).subscribe(res => {
            this.router.navigate(['features/core/department-management'])
        }, error => {
            console.log(error)
        })
    }

    setManagers() {
        if (!this.isSelected) {
            this.getManagers()
        }
        this.isSelected = true;
    }

    private getManagers() {
        this.employeeService.getManagers().subscribe(res =>
            this.managers = res
        )
    }
}
