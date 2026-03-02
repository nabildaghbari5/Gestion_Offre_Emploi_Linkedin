import {APP_INITIALIZER, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CoreModule} from "./core/core.module";
import {Router, RouterModule} from "@angular/router";
import {HttpClientModule, HttpClient} from "@angular/common/http";
import {BS_DATE_FORMAT, SharedModule} from "./shared/shared.module";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {MAT_DATE_FORMATS, MAT_DATE_LOCALE} from "@angular/material/core";
import {DatePipe} from "@angular/common";
import {KeycloakAngularModule} from 'keycloak-angular';
import {environment} from 'src/environments/environment.development';
import { UserService } from './features/bels-sage-core/services/user.service';
import { KeycloakService } from './service/keycloak.service';





export function HttpLoaderFactory(http: HttpClient): TranslateHttpLoader {
    return new TranslateHttpLoader(http);
}

export function kcFactory(kcService: KeycloakService) {
    return () => kcService.init();
  }

@NgModule({
    declarations: [
        AppComponent,
        
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        HttpClientModule,
        RouterModule,
        SharedModule,
        CoreModule,
        KeycloakAngularModule,
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: HttpLoaderFactory,
                deps: [HttpClient]
            }
        }),
    ],
    providers: [
        DatePipe,
        {provide: MAT_DATE_FORMATS, useValue: BS_DATE_FORMAT},
        {provide: MAT_DATE_LOCALE, useValue: 'en-GB'},
        UserService,
        {
            provide: APP_INITIALIZER,
            deps: [KeycloakService],
            useFactory: kcFactory,
            multi: true
          }
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
