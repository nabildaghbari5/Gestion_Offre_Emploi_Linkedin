import {Component, OnInit} from '@angular/core';
import {DepartmentService} from "../../services/department.service";
import {Router} from "@angular/router";
import {DialogComponent} from "../../../../shared/components/dialog/dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
    selector: 'app-department-management',
    templateUrl: './department-management.component.html',
    styleUrls: ['./department-management.component.scss']
})
export class DepartmentManagementComponent implements OnInit {
    displayedColumns: string[] = ['DEPARTMENT_MANAGEMENT.NAME', 'DEPARTMENT_MANAGEMENT.CODE', 'Manager', 'Address', 'Actions'];
    dataSource: any[] = [];
    filterForm!: FormGroup;


    constructor(private router: Router,
                public dialog: MatDialog,
                private formBuilder: FormBuilder,
                private departmentService: DepartmentService) {
        this.filterForm = this.formBuilder.group({
            namedepartment: [null],
            codedept: [null],
            managerdepartement: [null],
            currentpositionemployee: [null],
        });
    }

    ngOnInit(): void {
        this.getAll();
    }

    getAll() {
        this.departmentService.getAllDepartments().subscribe(data => {
            this.dataSource = data
        });
    }

    deleteDepartment(dep: any) {
        const code = dep.codedept;

        const dialogRef = this.dialog.open(DialogComponent, {
            width: '300px',
            data: {title: "Are you sure ?", text: "Are you sure you want to delete this item ?", error: false}
        });

        dialogRef.afterClosed().subscribe((response: string) => {
            if (response === 'YES') {
                this.departmentService.deleteDepartment(code).subscribe(res => {
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

    goToUpdateCompany(company: any) {
        this.router.navigate(['features/core/update-department', company.codedept])
    }

    filterDepartments() {
        this.departmentService.filterDepartments(this.filterForm.value).subscribe(data => {
            this.dataSource = data;
        }, error => {
            console.log(error)
        })
    }


}
