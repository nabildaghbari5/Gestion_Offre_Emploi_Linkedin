import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { HeaderComponent } from './components/header/header.component';
import {RouterLink} from "@angular/router";
import {TranslateModule} from "@ngx-translate/core";
import { NavbarComponent } from './components/navbar/navbar.component';



@NgModule({
  declarations: [
    SidebarComponent,
    HeaderComponent,
    NavbarComponent
  ],
    exports: [
        SidebarComponent,
        HeaderComponent,
        NavbarComponent
    ],
    imports: [
        CommonModule,
        RouterLink,
        TranslateModule
    ]
})
export class CoreModule { }
