import { Component, OnInit } from '@angular/core';
import {IService} from "../../../models/service";
import {ServersService} from "../../../service/servers.service";

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
 Iservices :IService[];
  constructor(private serviceSs : ServersService) { }

  ngOnInit(): void {
    this.serviceSs.getAllService().subscribe(data=>{
      this.Iservices=data;
    })
  }

}
