import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ICustomer, Icustomers} from "../../../models/customer";
import {Router} from "@angular/router";

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  updateCustomer: FormGroup;

  constructor(private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit(): void {
    this.updateCustomer=this.formBuilder.group({
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
    // this.customer
  }

  updateCus() {
    if(this.updateCustomer.valid){
      Icustomers.push(this.updateCustomer.value);
      this.router.navigateByUrl("/");
    }
  }
}
