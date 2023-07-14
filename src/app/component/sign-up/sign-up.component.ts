import { Component} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { catchError, of, tap } from 'rxjs';
import { SignUpService } from '../../service/sign-up.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  signUpForm: FormGroup;
  loginForm: FormGroup
  isSubmitted: boolean = false;
  showPopLogin: boolean = false;


  constructor(private formBuilder: FormBuilder,
    private signUpService: SignUpService,
    private router: Router,
    private loginService: LoginService) {

    this.signUpForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })

    this.loginForm = this.formBuilder.group({
      usernameLogin: ['', Validators.required],
      passwordLogin: ['', Validators.required]
    })

  }

  submitFormSignUp() {
    if (this.signUpForm.valid) {
      this.isSubmitted = true;
      const username = this.signUpForm.get('username')?.value;
      const password = this.signUpForm.get('password')?.value;
      this.signUpService.signUp(username, password).pipe(
        tap(response => {
          this.showPopLogin = true;
        }),
        catchError((error) => {
          return of([])
        })
      ).subscribe()
    }
  }

  loginFormOpen() {
    this.showPopLogin = true
  }

  close() {
    this.showPopLogin = false
  }

  onLogin() {
    if (this.loginForm.valid) {
      const username = this.loginForm.value.usernameLogin;
      const password = this.loginForm.value.passwordLogin;
      this.loginService.login(username, password).pipe(
        tap(response => {
          console.log("response", response);
          this.router.navigate(['/home'])
        })
      ).subscribe()
    }
  }

  ngOnInit() {

  }
}


