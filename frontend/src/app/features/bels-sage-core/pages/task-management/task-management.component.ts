import {Component, OnInit} from '@angular/core';
import {TaskService} from "../../services/task.service";
import {Router} from "@angular/router";
import {DialogComponent} from "../../../../shared/components/dialog/dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {FormBuilder, FormGroup} from "@angular/forms";
import {EmployeeService} from "../../services/employee.service";

@Component({
    selector: 'app-task-management',
    templateUrl: './task-management.component.html',
    styleUrls: ['./task-management.component.scss']
})
export class TaskManagementComponent implements OnInit {
    public dataSource: any[] = [];
    displayedColumns: string[] = ['title', 'description', 'start date', 'end date', 'task status', 'created by', 'assigned to', 'Actions'];
    filterForm!: FormGroup;
    public employees: any;
    public priorities = ['LOW', 'MEDIUM', 'HIGH'];
    public statues = ['PENDING', 'IN_PROGRESS' , 'COMPLETED','CANCELLED'];


    constructor(
        private router: Router,
        public  dialog: MatDialog,
        private formBuilder: FormBuilder,
        private taskService: TaskService,
        private employeeService: EmployeeService) {
        this.filterForm = this.formBuilder.group({
            title: [null],
            description: [null],
            startdate: [null],
            enddate: [null],
            status: [null],
            assignedTo: [null],
            createdBy: [null],
            priority: [null],
        });
        this.getEmployees();
    }

    ngOnInit() {
        this.getAllTasks();
    }

    getAllTasks(): void {
        this.taskService.getAllTasks().subscribe((result: any[]) => {
            this.dataSource = result;
        });
    }

    getEmployees() {
        this.employeeService.getAllEmployees().subscribe(res =>
            this.employees = res)
    }

    deleteTask(task: any) {
        const dialogRef = this.dialog.open(DialogComponent, {
            width: '300px',
            data: {title: "Are you sure ?", text: "Are you sure you want to delete this item ?", error: false}
        });

        dialogRef.afterClosed().subscribe((response: string) => {
            if (response === 'YES') {
                this.taskService.deleteTask(task.idtask).subscribe(res => {
                    this.getAllTasks()
                }, error => {
                    this.dialog.open(DialogComponent, {
                        width: '300px',
                        data: {title: "Error", text: "Error occurred while proceeding", error: true}
                    });
                })
            }
        })

    }

    goToUpdateTask(company: any) {
        this.router.navigate(['features/core/update-task', company.idtask])
    }

    filterTasks() {
        this.taskService.filterTasks(this.filterForm.value).subscribe(data => {
            this.dataSource = data;
        }, error => {
            this.dialog.open(DialogComponent, {
                width: '300px',
                data: {title: "Error", text: "Error occurred while proceeding", error: true}
            });
        })
    }
}
