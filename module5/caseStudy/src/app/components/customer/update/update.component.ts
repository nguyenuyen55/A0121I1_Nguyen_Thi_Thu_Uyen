import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ICustomer, Icustomers} from "../../../models/customer";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../../service/customer.service";
import {TypeCutomer} from "../create/create.component";

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  updateCustomer: FormGroup;
  typeCustomers :TypeCutomer[];
  constructor(private formBuilder:FormBuilder,private router:Router,private serviceCustomer:CustomerService,
              private activatedRoute:ActivatedRoute) { }

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
    this.serviceCustomer.getAllCustomerTypes().subscribe(data=>{
      this.typeCustomers=data;
      this.serviceCustomer.findById(this.activatedRoute.snapshot.params['id']).subscribe(data=>{
        console.log(data);
        this.updateCustomer.setValue(data);
      })
    })

  }
  // $('#myModal').modal('show');

  updateCus() {
    if(this.updateCustomer.valid){

      this.serviceCustomer.updateCustomer(this.updateCustomer.value,this.activatedRoute.snapshot.params['id']).subscribe(
        ()=>{
          this.router.navigateByUrl("/");
        }
      )
    }
  }
}
