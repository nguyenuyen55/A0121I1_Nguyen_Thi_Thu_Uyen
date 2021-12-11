import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';
import {ReactiveFormsModule} from '@angular/forms';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {NgxPaginationModule} from 'ngx-pagination';
import { ListComponent } from './component/list/list.component';
import { DeleteComponent } from './component/delete/delete.component';
import { CreateComponent } from './component/create/create.component';


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    DeleteComponent,
    CreateComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDialogModule,
    ReactiveFormsModule,
    // MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule,MatSnackBarModule
    ,NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
