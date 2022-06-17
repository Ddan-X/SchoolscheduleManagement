import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/model/login-request';

import { CourseService } from 'src/app/service/course.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginForm = new LoginRequest();

  constructor(private loginService: LoginService, private _router: Router) {}

  ngOnInit(): void {}

  login(): void {
    this.loginService.login(this.loginForm).subscribe({
      next: (result) => {
        var username = result.username;
        if (username == this.loginForm.username) {
          this._router.navigate(['/course/sche']);
        } else {
          console.log(result);
        }
      },
    });
  }
}
