import {Component, OnInit} from '@angular/core';
import {
    format,
    startOfMonth,
    endOfMonth,
    addMonths,
    subMonths,
    eachDayOfInterval,
    startOfWeek,
    endOfWeek, addWeeks, subWeeks
} from 'date-fns';


@Component({
    selector: 'app-timesheet',
    templateUrl: './timesheet.component.html',
    styleUrls: ['./timesheet.component.scss']
})
export class TimesheetComponent implements OnInit {
    timeSheetOptions = ["day", "week", "month"];
    currentDate: Date = new Date();
    days: Date[] = [];
    daysNames = ['sunday', 'monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    timesheetBase = "week";
    monthName = '';
    times = ["08.00", "08.30", "09.00"];
    workedHours = new Array(5);

    //dummy data
    subjects = [
        {
            description: "project A", details: [{
                start: "00.00", end: "00.00", timesheetId: 1
            }, {
                start: "00.00", end: "00.00", timesheetId: 2
            }, {
                start: "00.00", end: "00.00", timesheetId: 3
            }, {
                start: "00.00", end: "00.00", timesheetId: 4
            }, {
                start: "00.00", end: "00.00", timesheetId: 5
            }]
        },
        {
            description: "project B", details: [{
                start: "00.00", end: "00.00", timesheetId: 1
            }, {
                start: "00.00", end: "00.00", timesheetId: 2
            }, {
                start: "00.00", end: "00.00", timesheetId: 3
            }, {
                start: "00.00", end: "00.00", timesheetId: 4
            }, {
                start: "00.00", end: "00.00", timesheetId: 5
            }]
        },
        {
            description: "project C", details: [{
                start: "00.00", end: "00.00", timesheetId: 1
            }, {
                start: "00.00", end: "00.00", timesheetId: 2
            }, {
                start: "00.00", end: "00.00", timesheetId: 3
            }, {
                start: "00.00", end: "00.00", timesheetId: 4
            }, {
                start: "00.00", end: "00.00", timesheetId: 5
            }]
        },
        {
            description: "project D", details: [{
                start: "00.00", end: "00.00", timesheetId: 1
            }, {
                start: "00.00", end: "00.00", timesheetId: 2
            }, {
                start: "00.00", end: "00.00", timesheetId: 3
            }, {
                start: "00.00", end: "00.00", timesheetId: 4
            }, {
                start: "00.00", end: "00.00", timesheetId: 5
            }]
        }
    ]

    ngOnInit() {
        this.setTimeSheet();
    }

    setTimeSheet(): void {
        switch (this.timesheetBase) {
            case "week": {
                const start = startOfWeek(this.currentDate);
                const end = endOfWeek(this.currentDate);
                this.days = eachDayOfInterval({start, end});
                break;
            }
            case "month": {
                const start = startOfMonth(this.currentDate);
                const end = endOfMonth(this.currentDate);
                this.days = eachDayOfInterval({start, end});
                break;
            }
        }
        this.monthName = format(this.currentDate, 'MMMM yyyy');
    }

    goToNext(): void {
        switch (this.timesheetBase) {
            case "week": {
                this.currentDate = addWeeks(this.currentDate, 1);
                break;
            }
            case "month": {
                this.currentDate = addMonths(this.currentDate, 1);
                break;
            }
        }
        this.setTimeSheet();
    }

    goToPrevious(): void {
        switch (this.timesheetBase) {
            case "week": {
                this.currentDate = subWeeks(this.currentDate, 1);
                break;
            }
            case "month": {
                this.currentDate = subMonths(this.currentDate, 1);
                break;
            }
        }

        this.setTimeSheet();
    }

    addSubject() {
        /*
        this.subjects.push({
            description: "Last", details: [{
                start: "00.00", end: "00.00"
            }, {
                start: "00.00", end: "00.00"
            }, {
                start: "00.00", end: "00.00"
            }, {
                start: "00.00", end: "00.00"
            }, {
                start: "00.00", end: "00.00"
            }]
        })*/
    }
    deleteSubject(subjectIndex: number) {
        this.subjects.splice(subjectIndex, 1);
    }


}
