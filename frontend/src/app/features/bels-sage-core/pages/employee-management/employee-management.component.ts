import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../services/employee.service";
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {DialogComponent} from "../../../../shared/components/dialog/dialog.component";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
    selector: 'app-employee-management',
    templateUrl: './employee-management.component.html',
    styleUrls: ['./employee-management.component.scss']
})
export class EmployeeManagementComponent implements OnInit {
    title = 'EMPLOYEES_MANAGEMENT.TITLE';
    dataSource: any[] = [];
    displayedColumns: string[] = ['EMPLOYEES_MANAGEMENT.FIRST_NAME', 'EMPLOYEES_MANAGEMENT.LAST_NAME', 'Birthdate', 'EMPLOYEES_MANAGEMENT.GENDER', 'EMPLOYEES_MANAGEMENT.POSITION'
        , 'EMPLOYEES_MANAGEMENT.MANAGER', 'Address', 'EMPLOYEES_MANAGEMENT.DEPARTMENT', 'ACTIONS'];

    filterForm!: FormGroup;


    constructor(private router: Router,
                public dialog: MatDialog,
                private formBuilder: FormBuilder,
                private employeeService: EmployeeService) {

        this.filterForm = this.formBuilder.group({
            firstnameemployee: [null, Validators.required],
            lastnameemployee: [null, Validators.required],
            genderemployee: [null, Validators.required],
            currentpositionemployee: [null, Validators.required],
            currentmanageremployee: [null],
            currentdepartmentemployee: [null],
            telephone: [null],
            email: [null],
        });
    }

    ngOnInit() {
        this.getAll()
    }

    getAll() {
        this.employeeService.getAllEmployees().subscribe(data => {
            this.dataSource = data;
        })
    }

    deleteEmployee(employee: any) {
        const id = employee.idemployee;

        const dialogRef = this.dialog.open(DialogComponent, {
            width: '300px',
            data: {title: "Are you sure ?", text: "Are you sure you want to delete this item ?", error: false}
        });

        dialogRef.afterClosed().subscribe((response: string) => {
            if (response === 'YES') {
                this.employeeService.deleteEmployee(id).subscribe(res => {
                    this.getAll()

                }, error => {
                    this.dialog.open(DialogComponent, {
                        width: '300px',
                        data: {title: "Error", text: "Error occurred while proceeding", error: true}
                    });
                })
            }
        })
    }

    goToUpdateEmployee(employee: any) {
        this.router.navigate(['features/core/update-employee', employee.idemployee])
    }

    filterEmployee() {
        this.employeeService.filteremployee(this.filterForm.value).subscribe(data => {
            this.dataSource = data;
        }, error => {
            console.log(error)
        })
    }

    goToAddUser(idEmployee: number) {
        this.router.navigate(['/features/core/add-user', idEmployee]);
    }
}
