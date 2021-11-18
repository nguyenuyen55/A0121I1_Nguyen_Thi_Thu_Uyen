import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'feature-change-font-size';
  fontSize = 14;
  onChange(value) {
    this.fontSize = value;
}
}

