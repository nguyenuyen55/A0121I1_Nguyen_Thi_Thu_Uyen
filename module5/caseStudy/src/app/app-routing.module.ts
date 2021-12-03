import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from "./components/customer/list/list.component";
import {CreateComponent} from "./components/customer/create/create.component";
// import {CreateComponent} from "./components/customer/create/create.component";
// import * as path from "path";


const routes: Routes = [{
  path:'',component:ListComponent},
  {path:'createCustomer',component: CreateComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
