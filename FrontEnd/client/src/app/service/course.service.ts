import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { TeachersResponse } from '../interfaces/teachers-response';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private baseUrl = 'http://localhost:8080/api/course/';
  constructor(private _httpClient: HttpClient) {}

  getAllTeachers(apartmentName: string) {
    return this._httpClient.get<TeachersResponse[]>(
      this.baseUrl + '/teachers/' + apartmentName
    );
  }
}
