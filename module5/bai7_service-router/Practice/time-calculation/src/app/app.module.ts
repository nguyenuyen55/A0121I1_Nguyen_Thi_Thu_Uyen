import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TimelinesComponent } from './timelines/timelines.component';
import {RouterModule} from "@angular/router";
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
// import {AppRoutingModule} from "./app-routing.module";

@NgModule({
  declarations: [
    TimelinesComponent,
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
