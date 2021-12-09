import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IService} from "../models/service";

@Injectable({
  providedIn: 'root'
})
export class ServersService {

  constructor(private httpClient :HttpClient) { }
  URL_SERVER="http://localhost:3000/services";

  getAllService():Observable<IService[]>{
    return this.httpClient.get<IService[]>(this.URL_SERVER);
  }
  createService(services:IService){
    // console.log(services);
    return this.httpClient.post(this.URL_SERVER,services);
  }
  updateService(services:IService,id){
    return this.httpClient.put(this.URL_SERVER+'/'+id,services);
  }
  getById(id):Observable<IService>{
    return this.httpClient.get<IService>(this.URL_SERVER+'/'+id);
  }
}
