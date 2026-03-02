import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TaskService} from "../../services/task.service";
import {EmployeeService} from "../../services/employee.service";
import {Router} from "@angular/router";
import {DatePipe} from "@angular/common";

@Component({
    selector: 'app-add-task',
    templateUrl: './add-task.component.html',
    styleUrls: ['./add-task.component.scss']
})
export class AddTaskComponent {

    public formGroup: FormGroup;
    public employees: any
    public priorities = ['LOW', 'MEDIUM', 'HIGH'];
    public statues = ['PENDING', 'IN_PROGRESS' , 'COMPLETED','CANCELLED'];


    constructor(
        private router: Router,
        private datePipe: DatePipe,
        private formBuilder: FormBuilder,
        private taskService: TaskService,
        private employeeService: EmployeeService
    ) {
        this.formGroup = this.formBuilder.group({
            title: [null, Validators.required],
            description: [null, Validators.required],
            startdate: [null, Validators.required],
            enddate: [null, Validators.required],
            taskstatus: [null, Validators.required],
            assignedTo: [null, Validators.required],
            createdBy: [null, Validators.required],
            priority: [null, Validators.required],
            status: [null, Validators.required],
            employee: [null, Validators.required],
            documents: [null, Validators.required],
        });

        this.getEmployees();
    }

    getEmployees() {
        this.employeeService.getAllEmployees().subscribe(res =>
            this.employees = res)
    }

    addTask() {
        //set date format
        this.formGroup.patchValue({
            startdate: this.datePipe.transform(this.formGroup.controls['startdate'].value, 'yyyy-MM-dd'),
            enddate: this.datePipe.transform(this.formGroup.controls['enddate'].value, 'yyyy-MM-dd'),
        })
        this.taskService.addTask(this.formGroup.value).subscribe(res =>
            this.router.navigate(['/features/core/task-management'])
        )
    }
}
