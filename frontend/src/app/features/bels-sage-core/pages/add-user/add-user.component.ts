import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProfileService} from "../../services/profile.service";
import {EmployeeService} from "../../services/employee.service";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    selector: 'app-add-user',
    templateUrl: './add-user.component.html',
    styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent {
    public formGroup: FormGroup;
    public profiles = [''];
    public employees: any;
    roles = ["Administrator", "Human_Resource_Director", "Human_Resource", "Manager", "Collaborator"];


    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private userService: UserService,
        private profileService: ProfileService,
        private employeeService: EmployeeService,
    ) {
        this.formGroup = this.formBuilder.group({
            username: [null, [Validators.email, Validators.required]],
            nameusers: [null, Validators.required],
            surnameusers: [ null, Validators.required],
            password: [null, Validators.required],
            roles:[null, Validators.required],
            profileuser: [null],
            associatedemployeeuser: [null],
        });
        const employeeId = this.route.snapshot.paramMap.get('id');
        if (employeeId) {
            const id = employeeId as unknown as number;
            this.employeeService.getEmployeeById(id).subscribe(employee => {
                this.formGroup.patchValue({
                    associatedemployeeuser: employee,
                    nameusers:employee.firstnameemployee,
                    surnameusers:employee.lastnameemployee,
                    roles: employee.roles,
                });
            });
        }
        this.getProfiles();
        this.getEmployee();
    }

    getProfiles() {
        this.profileService.getAllProfiles().subscribe(profiles =>
            this.profiles = profiles)
    }

    getEmployee() {
        this.employeeService.getAllEmployees().subscribe(employees =>
            this.employees = employees)
    }

    addUser() {
        this.userService.addUser(this.formGroup.value).subscribe(res =>
            this.router.navigate(['/features/core/user-management'])
        )
    }
}
