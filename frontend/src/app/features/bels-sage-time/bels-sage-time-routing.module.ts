import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TimesheetComponent} from "./pages/timesheet/timesheet.component";

const routes: Routes = [
    {path: 'timesheet', component: TimesheetComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BelsSageTimeRoutingModule { }
