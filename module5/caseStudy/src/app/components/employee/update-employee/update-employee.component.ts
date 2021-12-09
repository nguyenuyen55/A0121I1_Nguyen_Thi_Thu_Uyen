import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../../service/employee.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  constructor(private serviceEmployee:EmployeeService,private activatedRoute:ActivatedRoute,
              private snackBar:MatSnackBar,
              private route:Router,
              private fb:FormBuilder) { }
updateEmployee:FormGroup;

  ngOnInit(): void {
    this.updateEmployee=this.fb.group({
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
    this.serviceEmployee.getById(this.activatedRoute.snapshot.params['id']).subscribe(data=>{
      console.log(data);
      this.updateEmployee.setValue(data);
    })
  }

  onUpdate() {
    this.serviceEmployee.updateEmployee(this.updateEmployee.value,this.activatedRoute.snapshot.params['id']).subscribe(()=>{
      this.snackBar.open("Bạn đã cập nhật thành công","Ok");
      this.route.navigateByUrl("/employee");
    })
  }
}
