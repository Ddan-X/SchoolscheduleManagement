import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { TeachersResponse } from '../interfaces/teachers-response';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private baseUrl = 'http://localhost:9010/api/school';
  constructor(private _httpClient: HttpClient) {}

  getAllTeachers(apartmentName: string) {
    return this._httpClient.get<TeachersResponse[]>(
      this.baseUrl + '/apartment/' + apartmentName
    );
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
