import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Icustomers} from "../../../models/customer";
import {employees} from "../../../models/employee";

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  createEmployee: FormGroup;

  constructor(private fb :FormBuilder) { }

  ngOnInit(): void {
    this.createEmployee=this.fb.group({
      id :['',[Validators.required,Validators.pattern(/NV-[0-9]{4}$/)]],
      name :['',Validators.required],
      birthday :['',Validators.required],
      idCard :['',Validators.required],
      salary :['',Validators.required],
      phone :['',Validators.required],
      email :['',Validators.required],
      address :['',Validators.required],
      positionId :['',Validators.required],
      eductionId :['',Validators.required],
      divisionId :['',Validators.required],
      username :['',Validators.required]
    })
  }

  onSubmit() {
    if(this.createEmployee.invalid){
      console.log(this.createEmployee.value);
      employees.push(this.createEmployee.value);

    }
  }
}
