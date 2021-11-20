import { Component, OnInit } from '@angular/core';
import {IContract} from "../../../models/contract";

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {

  constructor() { }
contracts =IContract;
  ngOnInit(): void {
  }

}
