import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/home/header/header.component';
import { FooterComponent } from './components/home/footer/footer.component';
import { ListComponent } from './components/customer/list/list.component';
import { CreateComponent } from './components/customer/create/create.component';
import { UpdateComponent } from './components/customer/update/update.component';
import { ListEmployeeComponent } from './components/employee/list-employee/list-employee.component';
import { CreateEmployeeComponent } from './components/employee/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './components/employee/update-employee/update-employee.component';

import { ListServiceComponent } from './components/service/list-service/list-service.component';
import { CreateServiceComponent } from './components/service/create-service/create-service.component';
import { UpdateServiceComponent } from './components/service/update-service/update-service.component';
import { ListContractComponent } from './components/contract/list-contract/list-contract.component';
import { CreateContractComponent } from './components/contract/create-contract/create-contract.component';
import { ListContracDetailComponent } from './components/contractDetail/list-contrac-detail/list-contrac-detail.component';
import { CreateContractDetailComponent } from './components/contractDetail/create-contract-detail/create-contract-detail.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { DeleteComponent } from './components/customer/delete/delete.component';
import {MatDialogModule} from "@angular/material/dialog";
import {NgxPaginationModule} from "ngx-pagination";
import { DeleteEmployeeComponent } from './components/employee/delete-employee/delete-employee.component';

// @ts-ignore
// import {MatSnackBarModule, MatFormFieldModule, MatSelectModule, MatCheckboxModule, MatInputModule, } from '@angular/material';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ListComponent,
    CreateComponent,
    UpdateComponent,
    ListEmployeeComponent,
    CreateEmployeeComponent,
    UpdateEmployeeComponent,

    ListServiceComponent,
    CreateServiceComponent,
    UpdateServiceComponent,
    ListContractComponent,
    CreateContractComponent,
    ListContracDetailComponent,
    CreateContractDetailComponent,
    DeleteComponent,
    DeleteEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,MatSnackBarModule,
    MatDialogModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
