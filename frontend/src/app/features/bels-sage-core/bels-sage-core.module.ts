import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CompanyManagementComponent} from './pages/company-management/company-management.component';
import {SharedModule} from "../../shared/shared.module";
import {BelsSageCoreRoutingModule} from "./bels-sage-core-routing.module";
import {AddCompanyComponent} from './pages/add-company/add-company.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {AddGroupComponent} from './pages/add-group/add-group.component';
import {AddCityComponent} from './pages/add-city/add-city.component';
import {AddZipCodeComponent} from './pages/add-zip-code/add-zip-code.component';
import {AddUserComponent} from './pages/add-user/add-user.component';
import {AddTaskComponent} from './pages/add-task/add-task.component';
import {AddDepartmentComponent} from './pages/add-department/add-department.component';
import {AddEmployeeComponent} from './pages/add-employee/add-employee.component';
import {AddCountryComponent} from './pages/add-country/add-country.component';
import {
    ListFunctionalitiesManagementComponent
} from './pages/list-functionalities-management/list-functionalities-management.component';
import {CountryManagementComponent} from './pages/country-management/country-management.component';
import {ZipCodeManagementComponent} from './pages/zip-code-management/zip-code-management.component';
import {CityManagementComponent} from './pages/city-management/city-management.component';
import {TaskManagementComponent} from './pages/task-management/task-management.component';
import {UserManagementComponent} from './pages/user-management/user-management.component';
import {EmployeeManagementComponent} from './pages/employee-management/employee-management.component';
import {GroupManagementComponent} from './pages/group-management/group-management.component';
import {UpdateCityComponent} from './pages/update-city/update-city.component';
import {UpdateCompanyComponent} from './pages/update-company/update-company.component';
import {UpdateCountryComponent} from './pages/update-country/update-country.component';
import {UpdateDepartmentComponent} from './pages/update-department/update-department.component';
import {UpdateEmployeeComponent} from './pages/update-employee/update-employee.component';
import {UpdateGroupComponent} from './pages/update-group/update-group.component';
import {UpdateTaskComponent} from './pages/update-task/update-task.component';
import {UpdateUserComponent} from './pages/update-user/update-user.component';
import {UpdateZipCodeComponent} from './pages/update-zip-code/update-zip-code.component';
import {DepartmentManagementComponent} from './pages/department-management/department-management.component';
import {TranslateModule} from "@ngx-translate/core";
import {FilterEmployeeComponent} from './pages/filter-employee/filter-employee.component';
import {CompanyService} from "./services/company.service";
import { ViewChartOrganizationComponent } from './pages/view-chart-organization/view-chart-organization.component';
import { ToastModule } from 'primeng/toast'; 
import { OrganizationChartModule } from 'primeng/organizationchart';
import { MessageService } from 'primeng/api';
import { PropertiesManagementComponent } from './pages/properties-management/properties-management.component';
import { EditPopupComponent } from './components/edit-popup/edit-popup.component'; 

@NgModule({
    declarations: [
        CompanyManagementComponent,
        AddCompanyComponent,
        AddGroupComponent,
        AddCityComponent,
        AddZipCodeComponent,
        AddUserComponent,
        AddTaskComponent,
        AddDepartmentComponent,
        AddEmployeeComponent,
        AddCountryComponent,
        ListFunctionalitiesManagementComponent,
        CountryManagementComponent,
        ZipCodeManagementComponent,
        CityManagementComponent,
        TaskManagementComponent,
        UserManagementComponent,
        EmployeeManagementComponent,
        GroupManagementComponent,
        UpdateCityComponent,
        UpdateCompanyComponent,
        UpdateCountryComponent,
        UpdateDepartmentComponent,
        UpdateEmployeeComponent,
        UpdateGroupComponent,
        UpdateTaskComponent,
        UpdateUserComponent,
        UpdateZipCodeComponent,
        DepartmentManagementComponent,
        FilterEmployeeComponent,
        ViewChartOrganizationComponent,
        PropertiesManagementComponent,
        EditPopupComponent,

    ],
    imports: [
        CommonModule,
        SharedModule,
        ReactiveFormsModule,
        BelsSageCoreRoutingModule,
        MatProgressSpinnerModule,
        TranslateModule,
        OrganizationChartModule,
        ToastModule,
        FormsModule,
    ],
    exports: [
        AddCompanyComponent
    ],
    providers: [
        MessageService,
        CompanyService
    ]
})
export class BelsSageCoreModule { }
