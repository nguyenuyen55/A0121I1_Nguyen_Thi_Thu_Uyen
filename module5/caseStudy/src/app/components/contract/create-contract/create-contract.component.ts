import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Icustomers} from "../../../models/customer";
import {IContract} from "../../../models/contract";

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {
  createContract: FormGroup;

  constructor(private formBuilder :FormBuilder) { }

  ngOnInit(): void {
    this.createContract=this.formBuilder.group({
      idContract:['',Validators.required],
      idEmployee:['',Validators.required],
      idCustomer:['',Validators.required],
      idService:['',Validators.required],
      dateCreate:['',Validators.required],
      dateEnd:['',Validators.required],
      deposits:[0],
      totalMoney:['',Validators.required]
    })
  }

  employees :any;
  // Iservices =services;
  customers =Icustomers;

  onSubmit() {
    // console.log(this.createContract.value);

    // if(this.createContract.invalid){
      console.log(this.createContract.value);
      IContract.push(this.createContract.value);
      console.log(IContract);
    // }
  }
}
