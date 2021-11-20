import { Component, OnInit } from '@angular/core';
import {employees} from "../../../models/employee";

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
employees=employees;
  constructor() { }

  ngOnInit(): void {
  }

}
