import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Sanpham} from '../../interface/sanpham';
import {LohangService} from '../../interface/lohang.service';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  create: FormGroup;
  sanphams: Sanpham[];

  constructor(private fb: FormBuilder, private services: LohangService, private route: Router,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {

    this.services.getAllsp().subscribe(data => (
      this.sanphams = data
    ));
    this.create = this.fb.group({
      id: ['', [Validators.required, Validators.pattern(/LH-[0-9]{4}$/)]],
      sanpham: ['', Validators.required],
      soluong: ['', [Validators.required, Validators.pattern(/^[0]{0,1}[1-9]{1,}$/)]],
      ngaynhap: ['', Validators.required],
      ngayxuat: ['', Validators.required],
      ngayhethan: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.create.valid) {
      this.services.create(this.create.value).subscribe(() => {
        this.snackBar.open('bạn đã thêm thành công', 'ok', {duration: 3000});
        this.route.navigateByUrl('/');
      });
    }
  }
}
