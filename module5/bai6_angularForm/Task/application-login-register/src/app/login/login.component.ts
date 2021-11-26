import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
function comparePassword(c: AbstractControl) {
  // debugger
  const v = c.value;
  return (v.password === v.comfirmPassword) ? null : {
    passwordnotmatch: true
  };
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private fb: FormBuilder) { }
register: FormGroup;
  ngOnInit(): void {
    this.register = this.fb.group({
      email:['',[Validators.required, Validators.email]],
      pwGroup: this.fb.group({
            password: ['',[Validators.required, Validators.minLength(6)]],
            comfirmPassword: ['',[Validators.required, Validators.minLength(6)]]

      }, {validator: comparePassword}),
      country: ['',Validators.required],
      age: ['',[Validators.required,Validators.min(18)]],
      gender: ['',Validators.required],
      phone: ['', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]]
    });
    // debugger
    // console.log(this.register.gender)
    //update form state
    this.register.patchValue(
      {email: 'info@example.com'}
    );
  }
onSubmit(){
    console.log(this.register);
}
}
