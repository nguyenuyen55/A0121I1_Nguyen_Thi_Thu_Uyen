import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DictinaryPageComponent } from './dictinary-page/dictinary-page.component';
import { DictinaryDetailComponent } from './dictinary-detail/dictinary-detail.component';
import { AppRoutingModule } from './app-routing.module';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    DictinaryPageComponent,
    DictinaryDetailComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        RouterModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
