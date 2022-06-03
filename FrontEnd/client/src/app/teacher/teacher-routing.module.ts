import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InvigilateComponent } from './invigilate/invigilate.component';
import { LoginComponent } from './login/login.component';
import { ScheduleComponent } from './schedule/schedule.component';

const routes: Routes = [
  {
    path: 'course/sche',
    component: ScheduleComponent,
  },
  { path: 'course/invig', component: InvigilateComponent },
  {
    path: 'login',
    component: LoginComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TeacherRoutingModule {}
