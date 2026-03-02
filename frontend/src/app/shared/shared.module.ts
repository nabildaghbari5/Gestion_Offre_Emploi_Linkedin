import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import {AddressComponent} from './components/address/address.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {A11yModule} from '@angular/cdk/a11y';
import {PortalModule} from '@angular/cdk/portal';
import {ScrollingModule} from '@angular/cdk/scrolling';
import {MatNativeDateModule, MatRippleModule} from '@angular/material/core';
import {MatDividerModule} from '@angular/material/divider';
import {MatInputModule} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatTableModule} from '@angular/material/table';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {TranslateModule} from "@ngx-translate/core";
import {RouterLink} from "@angular/router";
import {ContactComponent} from './components/contact/contact.component';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatDialogModule} from '@angular/material/dialog';
import {DialogComponent} from './components/dialog/dialog.component';
import {MatIconModule} from '@angular/material/icon';
import { PhoneValidatorDirective } from './datavalidator/PhoneValidatorDirective';
import { EmailValidatorDirective } from './datavalidator/EmailValidatorDirective';
import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';
import { CommentComponent } from './components/comment/comment.component';
import { OrganizationChartModule } from 'primeng/organizationchart'; 

export const BS_DATE_FORMAT = {
    parse: {
        dateInput: 'LL',
    },
    display: {
        dateInput: 'YYYY-MM-DD',
        monthYearLabel: 'MMM YYYY',
        dateA11yLabel: 'LL',
        monthYearA11yLabel: 'MMMM YYYY',
    },
};

const material = [
    MatButtonModule,
    A11yModule,
    MatDividerModule,
    MatInputModule,
    MatListModule,
    MatNativeDateModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    PortalModule,
    ScrollingModule,
    MatTableModule,
    MatSlideToggleModule,
    MatExpansionModule,
    MatDatepickerModule,
    MatDialogModule,
    MatIconModule

];


@NgModule({
    declarations: [
        AddressComponent,
        ContactComponent,
        DialogComponent,
        PhoneValidatorDirective,
        EmailValidatorDirective,
        CommentComponent
    ],
    imports: [
        CommonModule,
        material,
        TranslateModule,
        ReactiveFormsModule,
        RouterLink,
        FormsModule,
        NgxMatSelectSearchModule,
        OrganizationChartModule
    ],
    exports: [
        material,
        AddressComponent,
        ContactComponent,
        PhoneValidatorDirective,
        EmailValidatorDirective,
    ]
})
export class SharedModule {
}
