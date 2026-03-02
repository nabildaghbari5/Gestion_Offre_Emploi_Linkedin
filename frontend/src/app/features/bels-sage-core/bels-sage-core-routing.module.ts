import {NgModule} from '@angular/core';


import {RouterModule, Routes} from "@angular/router";
import {CompanyManagementComponent} from "./pages/company-management/company-management.component";
import {AddCompanyComponent} from "./pages/add-company/add-company.component";
import {UserManagementComponent} from "./pages/user-management/user-management.component";
import {EmployeeManagementComponent} from "./pages/employee-management/employee-management.component";
import {DepartmentManagementComponent} from "./pages/department-management/department-management.component";
import {GroupManagementComponent} from "./pages/group-management/group-management.component";
import {CityManagementComponent} from "./pages/city-management/city-management.component";
import {AddCityComponent} from "./pages/add-city/add-city.component";
import {TaskManagementComponent} from "./pages/task-management/task-management.component";
import {AddTaskComponent} from "./pages/add-task/add-task.component";
import {ZipCodeManagementComponent} from "./pages/zip-code-management/zip-code-management.component";
import {AddZipCodeComponent} from "./pages/add-zip-code/add-zip-code.component";
import {AddUserComponent} from "./pages/add-user/add-user.component";
import {AddEmployeeComponent} from "./pages/add-employee/add-employee.component";
import {AddDepartmentComponent} from "./pages/add-department/add-department.component";
import {CountryManagementComponent} from "./pages/country-management/country-management.component";
import {AddCountryComponent} from "./pages/add-country/add-country.component";
import {UpdateCityComponent} from "./pages/update-city/update-city.component";
import {UpdateCompanyComponent} from "./pages/update-company/update-company.component";
import {UpdateDepartmentComponent} from "./pages/update-department/update-department.component";
import {UpdateEmployeeComponent} from "./pages/update-employee/update-employee.component";
import {UpdateTaskComponent} from "./pages/update-task/update-task.component";
import {UpdateUserComponent} from "./pages/update-user/update-user.component";
import {UpdateCountryComponent} from "./pages/update-country/update-country.component";
import {UpdateZipCodeComponent} from "./pages/update-zip-code/update-zip-code.component";
import { ViewChartOrganizationComponent } from './pages/view-chart-organization/view-chart-organization.component';
import { AuthGuard } from 'src/app/auth-guard';
import {PropertiesManagementComponent} from "./pages/properties-management/properties-management.component";

const routes: Routes = [
    {
        path: 'company-management',
        component: CompanyManagementComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'company-management/add-company',
        component: AddCompanyComponent,
        canActivate: [AuthGuard],
    },  {
        path: 'update-company/:id',
        component: UpdateCompanyComponent,
        canActivate: [AuthGuard],
    },{
        path: 'user-management',
        component: UserManagementComponent,
        canActivate: [AuthGuard],
    },{
        path: 'update-user/:id',
        component: UpdateUserComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'add-user/:id',
        component: AddUserComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'employee-management',
        component: EmployeeManagementComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'employee-management/add-employee',
        component: AddEmployeeComponent,
        canActivate: [AuthGuard],
    },{
        path: 'update-employee/:id',
        component: UpdateEmployeeComponent,
        canActivate: [AuthGuard],
    },{
        path: 'department-management',
        component: DepartmentManagementComponent,
        canActivate: [AuthGuard],
    },  {
        path: 'department-management/add-department',
        component: AddDepartmentComponent,
        canActivate: [AuthGuard],
    },{
        path: 'update-department/:code',
        component: UpdateDepartmentComponent,
        canActivate: [AuthGuard],
    },{
        path: 'group-management',
        component: GroupManagementComponent,
        canActivate: [AuthGuard],
    },{
        path: 'country-management',
        component: CountryManagementComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'country-management/add-country',
        component: AddCountryComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'update-country/:code',
        component: UpdateCountryComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'city-management',
        component: CityManagementComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'city-management/add-city',
        component: AddCityComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'update-city/:id',
        component: UpdateCityComponent,
        canActivate: [AuthGuard],
    },{
        path: 'task-management',
        component: TaskManagementComponent,
        canActivate: [AuthGuard],
    },{
        path: 'update-task/:id',
        component: UpdateTaskComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'task-management/add-task',
        component: AddTaskComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'zipcode-management',
        component: ZipCodeManagementComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'update-zipcode/:id',
        component: UpdateZipCodeComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'zipcode-management/add-zipcode',
        component: AddZipCodeComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'vieworganizationChart',
        component: ViewChartOrganizationComponent,
        canActivate: [AuthGuard],
    }, {
        path: 'properties-management',
        component: PropertiesManagementComponent,
        canActivate: [AuthGuard],
    }

]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class BelsSageCoreRoutingModule {
}
