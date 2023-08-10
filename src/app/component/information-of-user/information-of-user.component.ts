import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, of, tap, throwError } from 'rxjs';
import { IinfoUsers } from 'src/app/Interface/IinfoUsers';
import { InformationOfUsersService } from 'src/app/service/information-of-users.service';

@Component({
  selector: 'app-information-of-user',
  templateUrl: './information-of-user.component.html',
  styleUrls: ['./information-of-user.component.css']
})
export class InformationOfUserComponent {

  infoUsersForm: FormGroup
  isSubmitted: boolean = false;
  notEmpty: boolean = false;

  constructor(private formBuilder: FormBuilder,
    private infoUserService: InformationOfUsersService,
    private router: Router) {

    this.infoUsersForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      lastName: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.minLength(3), Validators.email]],
      phone: ['', [Validators.required, Validators.minLength(8)]]
    })
  }

  saveForm() {
    if (this.infoUsersForm.valid) {
      this.isSubmitted = true;
      const name = this.infoUsersForm.get('name').value
      const lastName = this.infoUsersForm.get('lastName').value
      const email = this.infoUsersForm.get('email').value
      const phone = this.infoUsersForm.get('phone').value
      console.log(name, lastName, email, phone);
      this.infoUserService.addUsersInfo(name, lastName, phone, email).pipe(
        tap((response: IinfoUsers) => {
          console.log("res", response);
          this.router.navigate(['/finish'])
        }),
        catchError((error) =>{
          console.error("greska pri slanju");
          return throwError('doslo je do greske infoUsersForm')
        })
      ).subscribe()
    } else{
      this.notEmpty = true;
    }
  }

}
