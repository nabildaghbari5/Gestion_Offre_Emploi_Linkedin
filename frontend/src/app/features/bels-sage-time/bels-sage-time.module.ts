import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BelsSageTimeRoutingModule } from './bels-sage-time-routing.module';
import { TimesheetComponent } from './pages/timesheet/timesheet.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    TimesheetComponent,
  ],
    imports: [
        CommonModule,
        BelsSageTimeRoutingModule,
        ReactiveFormsModule,
        FormsModule
    ]
})
export class BelsSageTimeModule { }
