import { NgModule } from '@angular/core';


import { RouterModule, Routes } from "@angular/router";


const routes: Routes = [
     {
        path: 'offre',
        loadChildren: () => import('./offre/offre.module').then(m => m.OffreModule)
      },
      {
        path: 'demandes',
        loadChildren: () => import('./demandes/demandes.module').then(m => m.DemandesModule)
      },
      {
        path: 'entretiens',
        loadChildren: () => import('./entretiens/entretiens.module').then(m => m.EntretiensModule)
      },
      {
        path: 'dashboard',
        loadChildren: () => import('./dashbord/dashbord.module').then(m => m.DashbordModule)
      }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class BelsSageTalentRoutingModule {
}
