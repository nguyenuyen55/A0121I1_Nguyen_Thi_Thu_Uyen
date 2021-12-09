import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ServersService} from "../../../service/servers.service";
import {ActivatedRoute, Router} from "@angular/router";
import {IRent} from "../create-service/create-service.component";

@Component({
  selector: 'app-update-service',
  templateUrl: './update-service.component.html',
  styleUrls: ['./update-service.component.css']
})
export class UpdateServiceComponent implements OnInit {
 updateService:FormGroup;
  constructor(private formBuilder: FormBuilder,
              private services:ServersService,
              private route:Router,
              private activatedRoute:ActivatedRoute) {

  }

  ngOnInit(): void {
    this.updateService = this.formBuilder.group({
      id: ['',[Validators.required,Validators.pattern(/DV-[0-9]{4}$/)]],
      name: ['', Validators.required],
      area: ['', Validators.required],
      floors: ['', Validators.required],
      maxPeople: ['', Validators.required],
      constRent: ['', Validators.required],
      idRent: ['', Validators.required],
      status: ['CHƯA THUÊ']
    })
    this.services.getById(this.activatedRoute.snapshot.params['id']).subscribe(data=>{
      this.updateService.setValue(data);
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

  onUpdate() {
    this.services.updateService(this.updateService.value,this.updateService.value.id).subscribe(()=>{
      this.route.navigateByUrl("/service");
    })
  }
}
