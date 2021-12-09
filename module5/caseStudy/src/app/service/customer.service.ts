import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICustomer} from "../models/customer";
import {TypeCutomer} from "../components/customer/create/create.component";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient:HttpClient) { }
  URL_CUSTOMER="http://localhost:3000/customer";
  URL_CUSTOMERTYPE="http://localhost:3000/customerTypes";
  getAllCustomer():Observable<ICustomer[]>{
    return this.httpClient.get<ICustomer[]>(this.URL_CUSTOMER);
  }
  createCustomer(customer:ICustomer){
    return this.httpClient.post(this.URL_CUSTOMER,customer);
  }
  updateCustomer(customer:ICustomer,id:number){
    return this.httpClient.put(this.URL_CUSTOMER+'/'+id,customer);
  }
  findById(id:number):Observable<ICustomer>{
    return this.httpClient.get<ICustomer>(this.URL_CUSTOMER+'/'+id);
  }
  getAllCustomerTypes():Observable<TypeCutomer[]>{
    return this.httpClient.get<TypeCutomer[]>(this.URL_CUSTOMERTYPE);
  }
  deleteCustomer(id:string){
    return this.httpClient.delete(this.URL_CUSTOMER+'/'+id);
  }
  findByName(name:string):Observable<ICustomer[]>{
    return this.httpClient.get<ICustomer[]>(this.URL_CUSTOMER+'?customerName_like='+name);
  }
}
