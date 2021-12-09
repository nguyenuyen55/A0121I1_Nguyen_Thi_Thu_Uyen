import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from "./components/customer/list/list.component";
import {CreateComponent} from "./components/customer/create/create.component";
import {UpdateComponent} from "./components/customer/update/update.component";
import {CreateEmployeeComponent} from "./components/employee/create-employee/create-employee.component";
import {UpdateEmployeeComponent} from "./components/employee/update-employee/update-employee.component";
import {CreateContractComponent} from "./components/contract/create-contract/create-contract.component";
import {EmployeeService} from "./service/employee.service";
import {ListEmployeeComponent} from "./components/employee/list-employee/list-employee.component";
import {ListServiceComponent} from "./components/service/list-service/list-service.component";
import {CreateServiceComponent} from "./components/service/create-service/create-service.component";
import {UpdateServiceComponent} from "./components/service/update-service/update-service.component";
// import {CreateComponent} from "./components/customer/create/create.component";
// import * as path from "path";


const routes: Routes = [{
  path:'',component:ListComponent},
  {path:'createCustomer',component: CreateComponent},
  {path:'updateCustomer/:id',component: UpdateComponent},
  {path:'createEmployee',component: CreateEmployeeComponent},
  {path:'updateEmployee/:id',component: UpdateEmployeeComponent},
  {path:'createContract',component: CreateContractComponent},
  {path:'employee',component: ListEmployeeComponent},
  {path:'service',component: ListServiceComponent},
  {path:'createService',component: CreateServiceComponent},
  {path:'updateService/:id',component: UpdateServiceComponent}
  // {path:'createEmployee',component: ListEmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
