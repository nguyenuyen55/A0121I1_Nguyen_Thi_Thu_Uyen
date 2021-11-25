// @ts-ignore
import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-likes',
  templateUrl: './likes.component.html',
  styleUrls: ['./likes.component.css']
})
export class LikesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  @Input()
  likes: number ;
  likeThis() {
    this.likes++;
  }
}
