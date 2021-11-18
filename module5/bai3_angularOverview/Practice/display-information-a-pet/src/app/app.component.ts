import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'display-information-a-pet';
name_pet="mimi";
name_imgage="https://lolipet.net/wp-content/uploads/2018/12/2.jpg";
constructor() { }
updatename(value :string){
  this.name_pet=value;
  console.log(value);
}
updateimg(value :string){
  this.name_imgage=value;
  console.log(value);
}
}
