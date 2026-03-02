import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EntretiensRoutingModule } from './entretiens-routing.module';
import { EntretiensListRhComponent } from './pages/entretiens-list-rh/entretiens-list-rh.component';
import { ModifierEntretienComponent } from './pages/modifier-entretien/modifier-entretien.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [  
    EntretiensListRhComponent,
    ModifierEntretienComponent
  ],
  imports: [
    CommonModule,
    EntretiensRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class EntretiensModule { }
