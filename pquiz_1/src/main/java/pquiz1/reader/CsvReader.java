package pquiz1.reader;

import pquiz1.enrollment.Student;

import java.util.List;

public interface CsvReader {

    /**
     * Returns list of unique students.
     *
     * @return
     */
    List<Student> getStudents();

    /**
     * Returns list of unique students enrolled in a given course.
     *
     * @param courseName
     * @return
     */
    List<Student> getStudentsEnrolledInCourse(String courseName);

    /**
     * Returns list of unique students enrolled in a given year.
     * @param year
     * @return
     */
    List<Student> getStudentsByEnrollYear(int year);
}
