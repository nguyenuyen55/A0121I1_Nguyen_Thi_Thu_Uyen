import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  constructor() { }
 tinh(){
  let number1 =Number( (document.getElementById("number1") as HTMLInputElement).value);
  let number2 =Number((document.getElementById("number2") as HTMLInputElement).value);
  let option:string = (document.getElementById("option") as HTMLInputElement).value;
let result:any ;
  switch (option) {
    case "+":
      result=number1+number2;
      break;
      case "-":
        result=number1-number2;
        break;
        case "/":
          result=number1/number2;
          break;
          case "*":
            result=number1*number2;
            break;
  
  }

document.getElementById("result").innerText=result;
}
  ngOnInit(): void { 

  }

}
