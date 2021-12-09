import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../../service/customer.service";
import {ICustomer} from "../../../models/customer";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  constructor(private dialogRef:MatDialogRef<DeleteComponent>,
              private serviceCustomer:CustomerService,
              @Inject(MAT_DIALOG_DATA) public data:any) { }
customer:ICustomer;
  ngOnInit(): void {
    this.customer=this.data;
  }


  submitDel() {
    this.serviceCustomer.deleteCustomer(this.customer.id).subscribe(()=>{
      this.dialogRef.close();
    })
  }
}
