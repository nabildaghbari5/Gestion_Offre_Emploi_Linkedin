import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {DialogComponent} from "../../../../shared/components/dialog/dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {EmployeeService} from "../../services/employee.service";

@Component({
    selector: 'app-user-management',
    templateUrl: './user-management.component.html',
    styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent implements OnInit {
    dataSource: any[] = [];
    displayedColumns: string[] = ['USER_MANAGEMENT.USER-NAME', 'USER_MANAGEMENT.USER_SURNAME', 'USER_MANAGEMENT.ASSOCIATED-EMPLOYEE', 'USER_MANAGEMENT.USER_ENABLED', 'ACTIONS'];
    filterForm!: FormGroup;
    public employees: any;
    public roles = ['Administrator', 'Human_Resource_Director', 'Human_Resource', 'Manager', 'Collaborator'];

    constructor(
        private router: Router,
        public dialog: MatDialog,
        private formBuilder: FormBuilder,
        private userService: UserService,
        private employeeService: EmployeeService) {
        this.filterForm = this.formBuilder.group({
            username: [null, [Validators.email]],
            nameusers: [null],
            surnameusers: [null],
            roles: [null],
            associatedemployeeuser: [null],
        });
        this.getEmployees();
    }

    ngOnInit() {
        this.getAll()
    }

    getEmployees() {
        this.employeeService.getAllEmployees().subscribe(res =>
            this.employees = res)
    }

    getAll() {
        this.userService.getAllUsers().subscribe(data => {
            this.dataSource = data;
        })
    }

    changeUserStatus(user: any) {
        user.enabled = !user.enabled;
        this.userService.updateUser(user).subscribe();
    }


    filterUsers() {
        this.userService.filterUsers(this.filterForm.value).subscribe(data => {
            this.dataSource = data;
        }, error => {
            this.dialog.open(DialogComponent, {
                width: '300px',
                data: {title: "Error", text: "Error occurred while proceeding", error: true}
            });
        })
    }

    goToUpdateUser(user: any) {
        this.router.navigate(['features/core/update-user', user.uidusers])
    }

    deleteUser(user: any) {
        this.userService.deleteUser(user.uidusers).subscribe(res =>
            this.getAll()
        )
    }
}
