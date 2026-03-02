import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EnvoyerDemandeComponent } from './pages/envoyer-demande/envoyer-demande.component';
import { DemandeCandidacyComponent } from './pages/demande-candidacy/demande-candidacy.component';
import { DemandeRhComponent } from './pages/demande-rh/demande-rh.component';
import { TestEvaluationComponent } from './pages/test-evaluation/test-evaluation.component';

const routes: Routes = [
  {
    path:'envoyer_demande/:id',
    component:EnvoyerDemandeComponent
  }, 
  {
    path:"mycandidatures",
    component:DemandeCandidacyComponent
  },
  {
    path:"candidatures",  
    component:DemandeRhComponent
  },
  {
    path:"test_evaluation",
    component:TestEvaluationComponent   
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DemandesRoutingModule { }
