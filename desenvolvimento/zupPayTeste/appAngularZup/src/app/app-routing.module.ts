import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductsComponent } from './products/products.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { PaymentProcessComponent } from './payment-process/payment-process.component';


import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'products',
    pathMatch: 'full'
  },
  {
    path: 'products',
    canActivate: [AuthGuard],
    component: ProductsComponent,
    data: { title: 'Products' }
  },
  {
    path: 'payment-process',
    canActivate: [AuthGuard],
    component: PaymentProcessComponent,
    data: { title: 'Payment Process' }
  },
  {
    path: 'login',
    component: LoginComponent,
    data: { title: 'Login' }
  },
  {
    path: 'register',
    component: RegisterComponent,
    data: { title: 'Register' }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
