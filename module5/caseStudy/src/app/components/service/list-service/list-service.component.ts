import { Component, OnInit } from '@angular/core';
import {services} from "../../../models/service";

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
 Iservices = services;
  constructor() { }

  ngOnInit(): void {
  }

}
