import { Component, OnInit } from '@angular/core';
import { TeachersResponse } from 'src/app/interfaces/teachers-response';
import { CourseService } from 'src/app/service/course.service';
import { CourseDetailResponse } from 'src/app/interfaces/course-detail-response';
import { CourseResponse } from 'src/app/interfaces/course-response';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css'],
})
export class ScheduleComponent implements OnInit {
  //teacherArray = {} as TeachersResponse;
  teacherArray: TeachersResponse[] = [];

  courseDetailArray: CourseDetailResponse[] = [];
  coursesArray: CourseResponse[] = [];
  apartmentName: string = '';

  constructor(private _courseService: CourseService) {}

  ngOnInit(): void {
    //console.log(this.apartmentName);
    //this.loadData(this.apartmentName);
  }

  loadData(apartmentName: string) {
    this._courseService.getAllTeachers(apartmentName).subscribe((data) => {
      console.log('call courseService: ' + apartmentName);
      console.log(data);
      // this.teacherArray = data;
      // this.coursesArray = data.coursesArray;
    });
  }
}
