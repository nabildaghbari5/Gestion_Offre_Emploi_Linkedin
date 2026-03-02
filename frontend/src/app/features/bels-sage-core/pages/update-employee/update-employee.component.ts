import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeService} from "../../services/employee.service";
import {DepartmentService} from "../../services/department.service";

@Component({
    selector: 'app-update-employee',
    templateUrl: './update-employee.component.html',
    styleUrls: ['./update-employee.component.scss']
})
export class UpdateEmployeeComponent implements OnInit {

    public formGroup!: FormGroup;
    public departments: any;
    public managers: any;
    isManagerSelected = false;
    isDepartmentSelected = false;

    genders = ["Female", "Male"];

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private employeeService: EmployeeService,
        private departmentService: DepartmentService,
    ) {
    }

    get address() {
        return this.formGroup.controls['addressemployee'] as FormGroup;
    }

    ngOnInit() {
        const employeeId = this.route.snapshot.paramMap.get('id');
        if (employeeId) {
            const id = employeeId as unknown as number;
            this.employeeService.getEmployeeById(id).subscribe(employee => {
                this.formGroup = this.formBuilder.group({
                    idemployee: [employee.idemployee, Validators.required],
                    firstnameemployee: [employee.firstnameemployee, Validators.required],
                    lastnameemployee: [employee.lastnameemployee, Validators.required],
                    birthdateemployee: [employee.birthdateemployee, Validators.required],
                    genderemployee: [employee.genderemployee, Validators.required],
                    currentpositionemployee: [employee.currentpositionemployee, Validators.required],
                    currentmanageremployee: [employee.currentmanageremployee],
                    currentdepartmentemployee: [employee.currentdepartmentemployee],
                    contactemployee: this.formBuilder.array([]),
                    addressemployee: this.formBuilder.group({
                        countryaddress: this.formBuilder.group({
                            codecountry: employee.addressemployee?.countryaddress?.codecountry,
                            countrydescription: employee.addressemployee?.countryaddress?.countrydescription
                        }),
                        cityaddress: this.formBuilder.group({
                            idcity: employee.addressemployee?.cityaddress?.idcity,
                            namecity: employee.addressemployee?.cityaddress?.namecity,
                            countrycity: employee.addressemployee?.cityaddress?.countrycity,
                        }),
                        zipcodeaddress: this.formBuilder.group({
                            idzipcode: employee.addressemployee?.zipcodeaddress?.idzipcode,
                            locationzipcode: employee.addressemployee?.zipcodeaddress?.locationzipcode,
                            codezipcode: employee.addressemployee?.zipcodeaddress?.codezipcode,
                            cityzipcode: employee.addressemployee?.zipcodeaddress?.cityzipcode,
                            countryzipcode: employee.addressemployee?.zipcodeaddress?.countryzipcode,

                        }),
                        buildingnumberaddress: employee.addressemployee.buildingnumberaddress
                    })
                })

                if (employee.contactemployee && employee.contactemployee.length > 0) {
                    employee.contactemployee.forEach((contact : any)=> this.addContact(contact));
                  }
                this.managers = [employee.currentmanageremployee];
                this.departments = [employee.currentdepartmentemployee];
            });

        }
    }

    updateEmployee() {
        this.employeeService.updateEmployee(this.formGroup.value).subscribe(res =>
            this.router.navigate(['features/core/employee-management'])
        )
    }

    public getManagers() {
        if (!this.isManagerSelected) {
            this.employeeService.getManagers().subscribe(res =>
                this.managers = res
            )
        }
        this.isManagerSelected = true;
    }

    public getDepartments() {
        this.departmentService.getAllDepartments().subscribe(res =>
            this.departments = res
        )
    }

    get contacts(): FormArray {
        return this.formGroup.get('contactemployee') as FormArray;
      }

    createContact(contact: any = {}): FormGroup {
        const group = this.formBuilder.group({
          idcontact: [contact.idcontact || null],
          typecontact: [contact.typecontact || 'Phone', Validators.required],
          countrycodecontact: [contact.countrycodecontact || null],
          valuecontact: [contact.valuecontact || null, Validators.required],
          relation: [contact.relation || null],
          owneremergency: [contact.owneremergency || null],
          valueemergencycontact: [contact.valueemergencycontact || null]
        });
    
        group.get('typecontact')?.valueChanges.subscribe(value => {
          if (value === 'Email') {
            group.get('countrycodecontact')?.clearValidators();
            group.get('valuecontact')?.setValidators([Validators.required, Validators.email]);
          } else if (value === 'Phone' || value === 'Mobile') {
            group.get('countrycodecontact')?.setValidators(Validators.required);
            group.get('valuecontact')?.setValidators([Validators.required, Validators.pattern(/^[0-9]*$/)]);
          }
          group.get('countrycodecontact')?.updateValueAndValidity();
          group.get('valuecontact')?.updateValueAndValidity();
        });
    
        return group;
      }

    addContact(contact: any = {}): void {
        const contactGroup = this.createContact(contact);
        this.contacts.push(contactGroup);
      }
    
      removeContact(index: number): void {
        this.contacts.removeAt(index);
      }

      getFormGroup(control: AbstractControl) {
        return control as FormGroup;
      }
    
      onContactFormValidityChange(index: number, isValid: boolean) {
        const contactArray = this.formGroup.get('contactemployee') as FormArray;
        contactArray.at(index).setErrors(isValid ? null : { invalid: true });
      }
}
