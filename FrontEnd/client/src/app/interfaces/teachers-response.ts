import { CourseDetailResponse } from './course-detail-response';
import { CourseResponse } from './course-response';

export interface TeachersResponse {
  apartmentName: string;
  teacherName: string;
  coursesArray: Array<CourseResponse>;
}
