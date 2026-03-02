import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {ProfileService} from "../../services/profile.service";
import {EmployeeService} from "../../services/employee.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    selector: 'app-update-user',
    templateUrl: './update-user.component.html',
    styleUrls: ['./update-user.component.scss']
})
export class UpdateUserComponent implements OnInit {
    public formGroup!: FormGroup;
    public profiles = [''];
    public employees: any[] = [];
    //
    isSelectedEmployee = false;

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private userService: UserService,
        private profileService: ProfileService,
        private employeeService: EmployeeService,
    ) {

        this.getProfiles();
    }

    ngOnInit() {
        const userId = this.route.snapshot.paramMap.get('id');
        if (userId) {
            const id = userId as unknown as number;
            this.userService.getUserById(id).subscribe(user => {
                this.formGroup = this.formBuilder.group({
                    uidusers: [user.uidusers],
                    username: [user.username, Validators.required],
                    surnameusers: [user.surnameusers, Validators.required],
                    profileuser: [user.profileuser, Validators.required],
                    associatedemployeeuser: [user.associatedemployeeuser, Validators.required],
                });
                this.employees = [user.associatedemployeeuser]
            })

        }
    }

    getProfiles() {

        this.profileService.getAllProfiles().subscribe(profiles =>
            this.profiles = profiles)
    }

    getEmployees() {
        if (!this.isSelectedEmployee) {
            this.employeeService.getAllEmployees().subscribe(employees =>
                this.employees = employees)
        }
        this.isSelectedEmployee = true;
    }

    updateUser() {
        this.userService.addUser(this.formGroup.value).subscribe(res =>
            this.router.navigate(['/features/core/user-management'])
        )
    }

}
