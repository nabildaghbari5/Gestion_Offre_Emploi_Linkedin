import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';
import { DepartmentService } from '../../services/department.service';
import { NonNullAssert } from '@angular/compiler';

@Component({
  selector: 'app-filter-employee',
  templateUrl: './filter-employee.component.html',
  styleUrls: ['./filter-employee.component.scss']
})
export class FilterEmployeeComponent {

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
          genderemployee: [null, Validators.required],
          currentpositionemployee: [null, Validators.required],
          currentmanageremployee: [null],
          currentdepartmentemployee: [null],
          telephone: this.formBuilder.array([]),
          email: this.formBuilder.array([])
      });
      this.getDepartments();
      this.getManagers();
  }

  filterEmployee() {
      this.employeeService.filteremployee(this.formGroup.value).subscribe(res => {
         this.router.navigate(['/features/core/employee-management']);
      }, error => {
          console.log(error)
      })
  }

  private getDepartments() {
      this.departmentService.getAllDepartments().subscribe(res =>
          this.departments = res
      )
  }

  private getManagers() {
      this.employeeService.getManagers().subscribe(res =>
          this.managers = res
      )
  }
}
