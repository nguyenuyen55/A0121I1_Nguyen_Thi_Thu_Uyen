import {Component, Inject, OnInit} from '@angular/core';
import {LohangService} from '../../interface/lohang.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Lohang} from '../../interface/lohang';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DeleteComponent>,private service:LohangService,
    @Inject(MAT_DIALOG_DATA) public data :any) { }
lohang:Lohang;
  ngOnInit(): void {
    this.lohang=this.data;
  }

  comfirmdel(id) {
    this.service.deteleById(this.lohang.id).subscribe(()=>{
      console.log(this.lohang.sanpham);
      this.dialogRef.close();
    })
}

  close() {
    this.dialogRef.close();
  }
}
