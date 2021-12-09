import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {IEmployee} from "../../../models/employee";
import {EmployeeService} from "../../../service/employee.service";

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {

  constructor(private dialogRef:MatDialogRef<DeleteEmployeeComponent>,
              @Inject(MAT_DIALOG_DATA) public data:any,
              private employeeService:EmployeeService) { }
employee:IEmployee;
  ngOnInit(): void {
    this.employee=this.data;
  }

  ondelete(id: string) {
   this.employeeService.deleteById(id).subscribe(()=>{
     this.dialogRef.close();
   })
  }
}
