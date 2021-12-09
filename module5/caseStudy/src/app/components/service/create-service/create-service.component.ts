import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Icustomers} from "../../../models/customer";
import {ServersService} from "../../../service/servers.service";
import {Route, Router} from "@angular/router";

export interface IRent {
  id: number,
  nameRent: string;
}

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {
  createService: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private services:ServersService,
              private route:Router) {

  }

  ngOnInit(): void {
    this.createService = this.formBuilder.group({
      id: ['',[Validators.required,Validators.pattern(/DV-[0-9]{4}$/)]],
      name: ['', Validators.required],
      area: ['', Validators.required],
      floors: ['', Validators.required],
      maxPeople: ['', Validators.required],
      constRent: ['', Validators.required],
      idRent: ['', Validators.required],
      status: ['CHƯA THUÊ']
    })
  }

  Rents: IRent[] = [{
    id: 1,
    nameRent: 'month'
  },{
    id: 2,
    nameRent: 'day'
  },{
    id: 3,
    nameRent: 'hour'
  }
  ]

  onSubmit() {
    console.log(this.createService.value);

    if(this.createService.valid){
      console.log(this.createService.value);
      this.services.createService(this.createService.value).subscribe(()=>{
     this.route.navigateByUrl("/service");
   })
    }
    // console.log(this.createService.value);
  }
}
