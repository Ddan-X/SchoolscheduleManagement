import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from '../interfaces/login-request';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private baseUrl = 'http://localhost:9010/login';
  constructor(private _httpClient: HttpClient) {}
  login(request: LoginRequest) {
    return this._httpClient.post(this.baseUrl, request);
  }
}
