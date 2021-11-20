import { Component, OnInit } from '@angular/core';
import {ICustomer, Icustomers} from "../../../models/customer";
// import {Icustomers} from "../../../dao/studentDao";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  customers =Icustomers;
  constructor() { }

  ngOnInit(): void {
  }

}
