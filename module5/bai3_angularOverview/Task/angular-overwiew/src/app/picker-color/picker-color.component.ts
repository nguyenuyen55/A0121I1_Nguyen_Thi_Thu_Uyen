import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-picker-color',
  templateUrl: './picker-color.component.html',
  styleUrls: ['./picker-color.component.css']
})
export class PickerColorComponent implements OnInit {

  constructor() { }
background ="#00e067";
  ngOnInit(): void {
  }
  onchange(value :string){
    this.background=value;

  }
}
