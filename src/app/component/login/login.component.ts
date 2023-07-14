import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { tap } from 'rxjs';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup;

  constructor( private loginService: LoginService,
    private formBuilder: FormBuilder,
    private router: Router ){

    this.loginForm = this.formBuilder.group({
      username: [ '', Validators.required ],
      password: [ '', Validators.required ]
    })
  }

  onLogin(){
    if( this.loginForm.valid ){
      const username = this.loginForm.value.username;
      const password = this.loginForm.value.password;
      this.loginService.login( username, password ).pipe(
        tap( response => {
          console.log("response",response);
          this.router.navigate(['/home'])
        })
      ).subscribe()
    }
  }


}
