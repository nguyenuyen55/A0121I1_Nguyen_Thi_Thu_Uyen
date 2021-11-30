import { Component, OnInit } from '@angular/core';
import {DictionaryService, IWord} from '../dictionary.service';

@Component({
  selector: 'app-dictinary-page',
  templateUrl: './dictinary-page.component.html',
  styleUrls: ['./dictinary-page.component.css']
})
export class DictinaryPageComponent implements OnInit {

  listWord: IWord[] = [];
  constructor(
    private dictionaryService: DictionaryService
    // public authService: AuthService
  ) { }

  ngOnInit() {
    this.listWord = this.dictionaryService.getAll();
  }


}
