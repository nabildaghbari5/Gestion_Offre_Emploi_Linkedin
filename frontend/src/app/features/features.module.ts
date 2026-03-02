import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FeaturesRoutingModule} from "./features-routing.module";
import {MainComponent} from "./main/main.component";
import {CoreModule} from "../core/core.module";
import {SelectCompanyComponent} from "./fullscreen/components/select-company/select-company.component";
import {SharedModule} from "../shared/shared.module";
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
    declarations: [
        MainComponent,
        SelectCompanyComponent
    ],
    imports: [
        CommonModule,
        SharedModule,
        CoreModule,
        FeaturesRoutingModule,
        ReactiveFormsModule,

    ]
})
export class FeaturesModule {
}
