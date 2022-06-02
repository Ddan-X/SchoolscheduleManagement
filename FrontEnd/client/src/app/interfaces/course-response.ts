import { CourseDetailResponse } from './course-detail-response';

export interface CourseResponse {
  courseName: string;
  courseDetailArray: Array<CourseDetailResponse>;
}
