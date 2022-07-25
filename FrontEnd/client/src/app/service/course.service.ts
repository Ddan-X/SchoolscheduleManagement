import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { TeachersResponse } from '../interfaces/teachers-response';
import { Observable, throwError, catchError } from 'rxjs';
import { LoginRequest } from '../model/login-request';
import { LoginResponse } from '../interfaces/login-response';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private baseUrl = 'http://localhost:9010/api/school';
  constructor(private _httpClient: HttpClient) {}

  login(request: LoginRequest): Observable<LoginResponse> {
    return this._httpClient
      .post<LoginResponse>(this.baseUrl + '/login', request)
      .pipe(catchError(this.errorHandler));
  }
  getAllTeachers(apartmentName: string): Observable<TeachersResponse[]> {
    return this._httpClient
      .get<TeachersResponse[]>(this.baseUrl + '/apartment/' + apartmentName)
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
