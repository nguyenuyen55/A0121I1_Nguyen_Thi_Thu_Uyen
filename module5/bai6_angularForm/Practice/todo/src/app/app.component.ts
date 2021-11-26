import { Component } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
interface ITodo {
  id: number;
  content: string;
  complete: boolean;
}

// tslint:disable-next-line:variable-name
let _id = 1;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'todo';

  userInput = new FormControl();
  todos: Array<ITodo> = [];
  constructor() { }
  onChange() {
    const {value} = this.userInput;
    if (value) {
      const todo: ITodo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.userInput.setValue('');
    }
  }

  toggleTodo(i) {
    this.todos[i].complete = !this.todos[i].complete;
  }
}
