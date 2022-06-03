import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TeacherRoutingModule } from './teacher-routing.module';
import { ScheduleComponent } from './schedule/schedule.component';
import { InvigilateComponent } from './invigilate/invigilate.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    ScheduleComponent,
    InvigilateComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    TeacherRoutingModule
  ]
})
export class TeacherModule { }
