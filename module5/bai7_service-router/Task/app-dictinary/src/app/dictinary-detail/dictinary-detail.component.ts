import { Component, OnInit } from '@angular/core';
import {DictionaryService, IWord} from '../dictionary.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-dictinary-detail',
  templateUrl: './dictinary-detail.component.html',
  styleUrls: ['./dictinary-detail.component.css']
})
export class DictinaryDetailComponent implements OnInit {
word: IWord;
sub: Subscription;
  constructor(private  activatedRoute: ActivatedRoute,
              private dictionaryService : DictionaryService) { }

  ngOnInit(): void {
  this.sub = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
    const key = paramMap.get('key');
    const meaning = this.dictionaryService.search(key);
    this.word = {
      key: key,
      meaning: meaning
    };
  });
}
ngOnDestroy(): void {
  this.sub.unsubscribe();
}
}
