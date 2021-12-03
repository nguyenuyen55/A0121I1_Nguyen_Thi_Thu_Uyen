import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Icustomers} from "../../../models/customer";
import {services} from "../../../models/service";

interface IRent {
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

  constructor(private formBuilder: FormBuilder) {

  }

  ngOnInit(): void {
    this.createService = this.formBuilder.group({
      idService: ['',[Validators.required,Validators.pattern(/DV-[0-9]{4}$/)]],
      name: ['', Validators.required],
      area: ['', Validators.required],
      floors: ['', Validators.required],
      maxPeople: ['', Validators.required],
      constRent: ['', Validators.required],
      idRent: ['', Validators.required],
      status: ['', Validators.required]
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
    if(this.createService.invalid){
      console.log(this.createService.value);
      services.push(this.createService.value);
    }
    // console.log(this.createService.value);
  }
}
