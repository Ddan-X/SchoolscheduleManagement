import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { LoginResponse } from '../interfaces/login-response';
import { LoginRequest } from '../model/login-request';

@Injectable({
  providedIn: 'root',
})
//not use any more
export class LoginService {
  private baseUrl = 'http://localhost:9010/api/school/etstst';
  constructor(private _httpClient: HttpClient) {}
  login(request: LoginRequest): Observable<LoginResponse> {
    return this._httpClient
      .post<LoginResponse>(this.baseUrl, request)
      .pipe(catchError(this.errorHandler));
  }
  //need to handle error HttpErrorResponse
  errorHandler(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error(error.error.message);
    } else {
      console.error(
        `Backend returned cade ${error.status},` + `body was: ${error.error}`
      );
    }
    return throwError(() => new Error(error.error.message));
  }
}
