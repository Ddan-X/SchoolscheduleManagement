import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TeacherRoutingModule } from './teacher-routing.module';
import { ScheduleComponent } from './schedule/schedule.component';
import { InvigilateComponent } from './invigilate/invigilate.component';


@NgModule({
  declarations: [
    ScheduleComponent,
    InvigilateComponent
  ],
  imports: [
    CommonModule,
    TeacherRoutingModule
  ]
})
export class TeacherModule { }
