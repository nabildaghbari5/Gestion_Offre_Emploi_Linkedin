import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TaskService} from "../../services/task.service";
import {EmployeeService} from "../../services/employee.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DatePipe} from "@angular/common";

@Component({
    selector: 'app-update-task',
    templateUrl: './update-task.component.html',
    styleUrls: ['./update-task.component.scss']
})
export class UpdateTaskComponent implements OnInit {

    public formGroup!: FormGroup;

    public assignedToEmployees: any[] = [];
    public createdByEmployees: any[] = [];
    public employees: any[] = [];

    //boolean flags
    isAssignedToSelected = false;
    isCreatedBySelected = false;
    isEmployeeSelected = false;


    public priorities = ['LOW', 'MEDIUM', 'HIGH'];
    public statues = ['PENDING', 'IN_PROGRESS', 'COMPLETED', 'CANCELLED'];


    constructor(
        private router: Router,
        private datePipe: DatePipe,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private taskService: TaskService,
        private employeeService: EmployeeService
    ) {
    }

    ngOnInit() {
        //this.getEmployees();
        const taskId = this.route.snapshot.paramMap.get('id');
        if (taskId) {
            const id = taskId as unknown as number;
            this.taskService.getTaskById(id).subscribe(task => {
                this.formGroup = this.formBuilder.group({
                    idtask: [task.idtask, Validators.required],
                    title: [task.title, Validators.required],
                    description: [task.description, Validators.required],
                    startdate: [task.startdate, Validators.required],
                    enddate: [task.enddate, Validators.required],
                    taskstatus: [task.taskstatus, Validators.required],
                    assignedTo: [task.assignedTo, Validators.required],
                    createdBy: [task.createdBy, Validators.required],
                    priority: [task.priority, Validators.required],
                    status: [task.status, Validators.required],
                    employee: [task.employee, Validators.required],
                    documents: [task.documents, Validators.required],
                });
                this.assignedToEmployees = [task.assignedTo];
                this.createdByEmployees = [task.createdBy];
                this.employees = [task.employee];
            })
        }
    }

    updateTask() {
        //set date format
        this.formGroup.patchValue({
            startdate: this.datePipe.transform(this.formGroup.controls['startdate'].value, 'yyyy-MM-dd'),
            enddate: this.datePipe.transform(this.formGroup.controls['enddate'].value, 'yyyy-MM-dd'),
        })
        this.taskService.updateTask(this.formGroup.value).subscribe(res => {
                this.router.navigate(['features/core/task-management'])
            }, error =>
                console.log(error)
        )
    }

    selectAssignedTo() {
        if (!this.isAssignedToSelected) {
            this.employeeService.getAllEmployees().subscribe(res =>
                this.assignedToEmployees = res
            )
        }
        this.isAssignedToSelected = true;
    }

    selectCreatedBy() {
        if (!this.isCreatedBySelected) {
            this.employeeService.getAllEmployees().subscribe(res =>
                this.createdByEmployees = res
            )
        }
        this.isCreatedBySelected = true;
    }

    selectEmployee() {
        if (!this.isEmployeeSelected) {
            this.employeeService.getAllEmployees().subscribe(res =>
                this.employees = res
            )

        }
        this.isEmployeeSelected = true;
    }

    getText(employee: any) {
        return employee.firstnameemployee + ' ' + employee.lastnameemployee;
    }
}
