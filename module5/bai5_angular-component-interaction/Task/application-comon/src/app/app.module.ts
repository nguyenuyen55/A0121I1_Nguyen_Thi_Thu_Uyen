import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';
import { CountdownTimerAliasComponent } from './countdown-timer-alias/countdown-timer-alias.component';
import { CountdownTimerEventComponent } from './countdown-timer-event/countdown-timer-event.component';

@NgModule({
  declarations: [
    AppComponent,
    RatingBarComponent,
    CountdownTimerComponent,
    CountdownTimerAliasComponent,
    CountdownTimerEventComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
