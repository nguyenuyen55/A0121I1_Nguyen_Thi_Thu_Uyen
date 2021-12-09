import {Component, OnInit} from '@angular/core';
import {ICustomer, Icustomers} from "../../../models/customer";
import {CustomerService} from "../../../service/customer.service";
import {MatDialog, MatDialogRef} from "@angular/material/dialog";
import {DeleteComponent} from "../delete/delete.component";
import {MatSnackBar} from "@angular/material/snack-bar";

// import {Icustomers} from "../../../dao/studentDao";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  customers: ICustomer[];

  constructor(private serviceCustomer: CustomerService,
              private dialog: MatDialog,
              private snack:MatSnackBar) {
  }

  ngOnInit(): void {
    this.serviceCustomer.getAllCustomer().subscribe(data => {
      this.customers = data;
    })
  }

  p: number = 1;

  openDialog(id) {
    this.serviceCustomer.findById(id).subscribe(data => {

      const dialogRef = this.dialog.open(DeleteComponent, {
        width: '500px',
        height: '500px',
        data: data
      })
      dialogRef.afterClosed().subscribe(()=>{
        this.ngOnInit();

      })


    })

  }

  search(value: string) {
    this.serviceCustomer.findByName(value).subscribe(data => {
  this.customers=data;
  this.p=1;
      console.log(this.customers);
      if(this.customers.length==0){
        this.snack.open("Không tìm thấy",'ok');
        this.ngOnInit();
      }
    })
  }
}
