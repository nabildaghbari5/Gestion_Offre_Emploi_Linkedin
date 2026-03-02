import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashbordRoutingModule } from './dashbord-routing.module';
import { StatistiqueComponent } from './statistique/statistique.component';


@NgModule({
  declarations: [
    StatistiqueComponent
  ],
  imports: [
    CommonModule,
    DashbordRoutingModule
  ]
})
export class DashbordModule { }
