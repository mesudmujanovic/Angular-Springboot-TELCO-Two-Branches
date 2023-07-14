import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { catchError, of, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { SignUpService } from '../../service/sign-up.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  signUpForm: FormGroup;
  isSubmitted: boolean = false;

  constructor(private formBuilder: FormBuilder,
    private signUpService: SignUpService) {

    this.signUpForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })

  }

  submitFormSignUp() {
   if( this.signUpForm.valid ) {
    this.isSubmitted = true;
    const username = this.signUpForm.get('username')?.value;
    const password = this.signUpForm.get('password')?.value;
     this.signUpService.signUp( username, password ).pipe(
      tap(response => {
        console.log("SignUpResponse",response);
      }),
      catchError(( error )=> {
        return of([])
      })
     ).subscribe()
     }
   }

  ngOnInit(){

  }
  }


