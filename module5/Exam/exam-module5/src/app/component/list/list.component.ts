import {Component, OnInit} from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';
import {LohangService} from '../../interface/lohang.service';
import {Lohang} from '../../interface/lohang';
import {MatDialog} from '@angular/material/dialog';
import {DeleteComponent} from '../delete/delete.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  lohangs: Lohang[];
  p: number = 1;

  constructor(private services: LohangService,
              private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.services.getAllLo().subscribe(data => {
      this.lohangs = data;
    });
  }

  opendialog(id) {
    this.services.findById(id).subscribe(data => {
      const dialogRef = this.dialog.open(DeleteComponent, {
        width: '500px',
        height: '500px',
        data: data
      });
      dialogRef.afterClosed().subscribe(() => {
        this.ngOnInit();
      });
    });


  }


  searchName(ten: string,date:string,date1,date2) {
    if(ten!=''){
      this.services.timkiemtensp(ten).subscribe(data => {
        this.lohangs = data;
        this.p=1;
      });
    }
    if (date!=''){
      this.services.timkiemNgayHetHan(date).subscribe(data => {
        this.lohangs = data;
        this.p=1;
      });
    }
    if(ten!=''&& ten!=''){
      this.services.timkiemtenvangay(ten,date).subscribe(data => {
        this.lohangs = data;
        this.p=1;
      });
    }
    if(date1!=''&& date2!=''){
      this.services.timkiemdatetodate(date1,date2).subscribe(data => {
        this.lohangs = data;
        this.p=1;
      });
    }
    if(ten!=''&& ten!=''&&date1!=''&& date2!=''){
      this.services.timkiem(ten,date,date1,date2).subscribe(data => {
        this.lohangs = data;
        this.p=1;
      });
    }
  }


}
