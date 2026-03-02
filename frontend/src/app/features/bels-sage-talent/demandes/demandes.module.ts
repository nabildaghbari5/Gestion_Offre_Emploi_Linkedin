import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DemandesRoutingModule } from './demandes-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EnvoyerDemandeComponent } from './pages/envoyer-demande/envoyer-demande.component';
import { DemandeCandidacyComponent } from './pages/demande-candidacy/demande-candidacy.component';
import { DemandeRhComponent } from './pages/demande-rh/demande-rh.component';
import { NgbDropdownModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TestEvaluationComponent } from './pages/test-evaluation/test-evaluation.component';


@NgModule({
  declarations: [
    EnvoyerDemandeComponent,
    DemandeCandidacyComponent,
    DemandeRhComponent,
    TestEvaluationComponent
  ],
  imports: [
    CommonModule,
    DemandesRoutingModule,
    FormsModule,
    ReactiveFormsModule,   
    NgbDropdownModule, 
    NgbModule


  ]
})
export class DemandesModule { }
