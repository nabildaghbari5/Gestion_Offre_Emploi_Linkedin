import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjouterOffreComponent } from './page/ajouter-offre/ajouter-offre.component';
import { ListOffreComponent } from './page/list-offre/list-offre.component';
import { ModifierOffreComponent } from './page/modifier-offre/modifier-offre.component';
import { AnnouncementCandidatComponent } from './page/announcement-candidat/announcement-candidat.component';
import { EnvoyerDemandeComponent } from '../demandes/pages/envoyer-demande/envoyer-demande.component';

const routes: Routes = [
  {
    path:"ajouter",
    component:AjouterOffreComponent
  },
  {
    path:"list-offre",
    component:ListOffreComponent
  },
  {
    path:"modifier/:id",
    component:ModifierOffreComponent
  },
  {
    path:'Announcement_Actuel',
    component:AnnouncementCandidatComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OffreRoutingModule { }
