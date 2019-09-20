import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { PaymentProcess } from '../payment-process/payment-process';

const apiUrl = 'http://localhost:8080/api/products';

@Injectable({
  providedIn: 'root'
})
export class PaymentProcessService {

  constructor(private http: HttpClient) { }

 
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error); // log to console instead
      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }

  private log(message: string) {
    console.log(message);
  }
}