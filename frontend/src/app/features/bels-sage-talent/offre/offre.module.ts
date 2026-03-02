import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AjouterOffreComponent } from './page/ajouter-offre/ajouter-offre.component';
import { ListOffreComponent } from './page/list-offre/list-offre.component';
import { ModifierOffreComponent } from './page/modifier-offre/modifier-offre.component';
import { OffreRoutingModule } from './offre-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AnnouncementCandidatComponent } from './page/announcement-candidat/announcement-candidat.component';



@NgModule({
  declarations: [
    AjouterOffreComponent,
    ListOffreComponent,
    ModifierOffreComponent,
    AnnouncementCandidatComponent
  ],
  imports: [
    CommonModule,
    OffreRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class OffreModule { }
