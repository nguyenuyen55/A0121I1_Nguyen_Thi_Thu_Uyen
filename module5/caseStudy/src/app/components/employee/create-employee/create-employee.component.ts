import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Icustomers} from "../../../models/customer";
import {EmployeeService} from "../../../service/employee.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  createEmployee: FormGroup;

  constructor(private fb :FormBuilder,
              private serviceService:EmployeeService,
              private snackBar:MatSnackBar,
              private route:Router) { }

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
     this.serviceService.createEmployee(this.createEmployee.value).subscribe(()=>{
       this.snackBar.open("Bạn thêm mới thành công",'OK',{duration:3000})
       this.route.navigateByUrl("/employee");
     })
      // employees.push(this.createEmployee.value);

    }
  }
}
