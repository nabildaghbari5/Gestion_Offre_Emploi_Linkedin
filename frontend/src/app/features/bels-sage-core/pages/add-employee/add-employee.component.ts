import { Component } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';
import { DepartmentService } from '../../services/department.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent {
  public formGroup: FormGroup;
  public departments: any;
  public managers: any;

  genders = ["Female", "Male"];
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private employeeService: EmployeeService,
    private departmentService: DepartmentService,
  ) {
    this.formGroup = this.formBuilder.group({
      firstnameemployee: [null, Validators.required],
      lastnameemployee: [null, Validators.required],
      birthdateemployee: [null, Validators.required],
      genderemployee: [null, Validators.required],
      currentpositionemployee: [null, Validators.required],
      currentmanageremployee: [null],
      currentdepartmentemployee: [null],
      addressemployee: this.formBuilder.group({
        countryaddress: this.formBuilder.group({
          codecountry: [null, Validators.required],
          countrydescription: [null, Validators.required],
        }),
        cityaddress: this.formBuilder.group({
          idcity: [null, Validators.required],
          namecity: [null, Validators.required],
          countrycity: [null, Validators.required],
        }),
        zipcodeaddress: this.formBuilder.group({
          idzipcode: [null, Validators.required],
          locationzipcode: [null, Validators.required],
          codezipcode: [null, Validators.required],
          cityzipcode: [null, Validators.required],
          countryzipcode: [null, Validators.required],
        }),
        buildingnumberaddress: [null, Validators.required],
      }),
      contactemployee: this.formBuilder.array([])
    });
    this.getDepartments();
    this.getManagers();
  }

  get contacts(): FormArray {
    return this.formGroup.get('contactemployee') as FormArray;
  }

  get address() {
    return this.formGroup.get('addressemployee') as FormGroup;
  }

  createContact(): FormGroup {
    return this.formBuilder.group({
      typecontact: [null],
      countrycodecontact: [null],
      valuecontact: [null],
      relation: [null],
      owneremergency: [null],
      valueemergencycontact: [null]
    });
  }

  addEmployee() {
    if (this.formGroup.valid) {
      this.employeeService.addEmployee(this.formGroup.value).subscribe(res => {
        this.router.navigate(['/features/core/employee-management']);
      }, error => {
        console.log(error);
      });
    }
  }

  getFormGroup(control: AbstractControl) {
    return control as FormGroup;
  }

  addContact(): void {
    const contactGroup = this.createContact();
    this.contacts.push(contactGroup);
  }

  removeContact(index: number): void {
    this.contacts.removeAt(index);
  }

  onContactFormValidityChange(index: number, isValid: boolean) {
    const contactArray = this.formGroup.get('contactemployee') as FormArray;
    contactArray.at(index).setErrors(isValid ? null : { invalid: true });
  }

  private getDepartments() {
    this.departmentService.getAllDepartments().subscribe(res => this.departments = res);
  }

  private getManagers() {
    this.employeeService.getManagers().subscribe(res => this.managers = res);
  }
}
