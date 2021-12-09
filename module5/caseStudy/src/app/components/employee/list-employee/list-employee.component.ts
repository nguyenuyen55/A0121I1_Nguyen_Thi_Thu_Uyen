import { Component, OnInit } from '@angular/core';
import { IEmployee} from "../../../models/employee";
import {EmployeeService} from "../../../service/employee.service";
import {MatDialog, MatDialogRef} from "@angular/material/dialog";
import {DeleteEmployeeComponent} from "../delete-employee/delete-employee.component";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
employees:IEmployee[];
  constructor(private servicEmployee:EmployeeService,private dialog:MatDialog,
            private snackBar:MatSnackBar ) { }

  ngOnInit(): void {
    this.servicEmployee.getAllEmployee().subscribe(data=>{
      this.employees=data;
    })
  }
  p:number=1;
  openDialog(id: string) {
    this.servicEmployee.getById(id).subscribe(data=>{
      const dialogRef= this.dialog.open(DeleteEmployeeComponent,{
        width:'500px',
        height:'500px',
        data:data
      })
      dialogRef.afterClosed().subscribe(()=>
      {
        this.snackBar.open("Bạn đã xoá thành công",'OK');
        this.ngOnInit();
      })
    })

  }

  searchempl(value: string) {
    this.servicEmployee.searchEmployee(value).subscribe(data=>{
this.employees=data;
    })
  }
}
