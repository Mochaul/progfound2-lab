package pquiz1b.reader;

import pquiz1b.enrollment.Course;
import pquiz1b.enrollment.Student;

import java.util.List;

public interface CsvReader {

    /**
     * Returns list of unique courses.
     *
     * @return
     */
    List<Course> getCourses();

    /**
     * Returns list of unique students enrolled in a given course.
     *
     * @param courseName
     * @return
     */
    List<Student> getStudentsEnrolledInCourse(String courseName);

    /**
     * Returns list of unique students from given batch year that enrolled in
     * a given course.
     *
     * @param courseName
     * @param year
     * @return
     */
    List<Student> getStudentsEnrolledInCourseByYear(String courseName,
                                                    int year);
}
