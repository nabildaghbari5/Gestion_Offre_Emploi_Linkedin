import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntretiensListRhComponent } from './pages/entretiens-list-rh/entretiens-list-rh.component';
import { ModifierEntretienComponent } from './pages/modifier-entretien/modifier-entretien.component';

const routes: Routes = [
  {
    path:"list_entretien",
    component:EntretiensListRhComponent
  },
  {
    path:"modifier_entretien/:id",
    component:ModifierEntretienComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EntretiensRoutingModule { }
