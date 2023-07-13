import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, catchError, of, tap } from 'rxjs';
import { UserJWT } from '../../Interface/UserJWT';
import { HttpClient } from '@angular/common/http';
import { SignUpService } from '../../service/sign-up.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  signUpForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private http: HttpClient,
    private signUpService: SignUpService) {

    this.signUpForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })

  }

  submitFormSignUp() {
   if( this.signUpForm.valid ) {
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


