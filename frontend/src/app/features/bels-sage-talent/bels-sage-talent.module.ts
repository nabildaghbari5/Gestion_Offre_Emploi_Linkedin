import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { RouterModule } from '@angular/router';
import {BelsSageTalentRoutingModule} from "./bels-sage-talent-routing.module";
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { OffreModule } from './offre/offre.module';

@NgModule({
  declarations: [
    
  ],
  imports: [
    CommonModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
    TranslateModule,
    BelsSageTalentRoutingModule,
    MatTooltipModule,
    MatTableModule,
    MatButtonModule,
    RouterModule ,
  ]  
})
export class BelsSageTalentModule { }
  