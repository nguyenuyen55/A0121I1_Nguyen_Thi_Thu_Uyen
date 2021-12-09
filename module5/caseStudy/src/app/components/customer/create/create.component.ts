import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Icustomers} from "../../../models/customer";
import {Route, Router} from "@angular/router";
import {CustomerService} from "../../../service/customer.service";
import {MatSnackBar} from "@angular/material/snack-bar";

export interface TypeCutomer {
  value: string;
  name: string;
}



@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  createCustomer: FormGroup;
typeCustomers :TypeCutomer[]=[
  {value: 'Diamond', name: 'Diamond'},
  {value: 'Platinum', name: 'Platinium'},
  {value: 'Gold', name: 'Gold'},
  {value: 'Silver', name: 'Silver'},
  {value: 'Member', name: 'Menber'},
];
  constructor(private fb: FormBuilder, private router:Router,
              private customerService:CustomerService,
  private snackBar:MatSnackBar) { }

  ngOnInit(): void {
    this.createCustomer = this.fb.group({
      id: ['',[Validators.required,Validators.pattern(/KH-[0-9]{4}$/)]],
      customerType: ['',Validators.required],
      customerName: ['',Validators.required],
      customerBirthday: ['',Validators.required],
      customerGender: ['',Validators.required],
      customerIdCard: ['',[Validators.required,Validators.pattern(/^[0-9]{9}?$|^[0-9]{12}$/)]],
      customerPhone: ['',[Validators.required,Validators.pattern(/^(091[0-9]{7})?$|^(090[0-9]{7})$/)]],
      customerEmail: ['',Validators.required],
      customerAddress: ['',Validators.required]
    })
  }

  onSubmit() {
console.log(this.createCustomer.value);
if(this.createCustomer.valid){
  this.customerService.createCustomer(this.createCustomer.value).subscribe()
    // Icustomers.push(this.createCustomer.value);
  this.snackBar.open("Bạn đã thêm thành công");
    this.router.navigateByUrl("/");

  }}
}
