import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {MainComponent} from "./main/main.component";
import {SelectCompanyComponent} from "./fullscreen/components/select-company/select-company.component";

const routes: Routes = [
    {
        path: '',
        component: MainComponent,
        children: [
            {
                path: 'core',
                loadChildren: () => import('./bels-sage-core/bels-sage-core.module').then(m => m.BelsSageCoreModule)
            }, {
                path: 'time',
                loadChildren: () => import('./bels-sage-time/bels-sage-time.module').then(m => m.BelsSageTimeModule)
            }
            ,
            {
                path: 'talent',
                loadChildren: ()=> import('./bels-sage-talent/bels-sage-talent.module').then(m => m.BelsSageTalentModule)
            }

        ]
    }, {
        path: 'select-company',
        component: SelectCompanyComponent
    }

]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class FeaturesRoutingModule {
}
