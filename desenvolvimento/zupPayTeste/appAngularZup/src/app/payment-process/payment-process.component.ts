import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { ErrorStateMatcher } from '@angular/material/core';
import {MatRadioModule} from '@angular/material/radio';


@Component({
  selector: 'app-payment-process',
  templateUrl: './payment-process.component.html',
  styleUrls: ['./payment-process.component.css']
})
export class PaymentProcessComponent implements OnInit {

  registerForm: FormGroup;
   

  description = ''; 
  amount = ''; 
  currency = ''; 

  isLoadingResults = false;
  matcher = new MyErrorStateMatcher();

  constructor(private formBuilder: FormBuilder, private router: Router, private authService: AuthService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      'description' : [null, Validators.required],
      'amount' : [null, Validators.required],
      'currency' : [null, Validators.required]  

    });
  }

  onFormSubmit(form: NgForm) {
    this.authService.payment(form)
      .subscribe(res => {
        this.router.navigate(['payment']);
      }, (err) => {
        console.log(err);
        alert(err.error);
      });
  }

}

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
