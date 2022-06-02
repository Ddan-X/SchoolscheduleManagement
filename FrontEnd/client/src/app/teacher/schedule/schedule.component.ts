import { Component, OnInit } from '@angular/core';
import { TeachersResponse } from 'src/app/interfaces/teachers-response';
import { CourseService } from 'src/app/service/course.service';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css'],
})
export class ScheduleComponent implements OnInit {
  teacherArray: TeachersResponse[] = [];
  constructor(private _courseService: CourseService) {}

  apartmentName: string = '';

  ngOnInit(): void {
    this.loadData(this.apartmentName);
  }

  loadData(apartmentName: string) {
    this._courseService.getAllTeachers(apartmentName).subscribe((teachers) => {
      this.teacherArray = teachers;
      console.log(teachers);
    });
  }
}
