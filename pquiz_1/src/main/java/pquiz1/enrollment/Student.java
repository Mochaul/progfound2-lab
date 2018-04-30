package pquiz1.enrollment;

import java.util.List;

public class Student {

    private final String id;
    private final int enrollYear;
    private final String degree;
    private final List<Course> enrolledCourse;

    public Student(String id, int enrollYear, String degree, List<Course> enrolledCourse) {
        this.id = id;
        this.enrollYear = enrollYear;
        this.degree = degree;
        this.enrolledCourse = enrolledCourse;
    }

    public String getId() {
        return id;
    }

    public int getEnrollYear() {
        return enrollYear;
    }

    public String getDegree() {
        return degree;
    }

    public List<Course> getEnrolledCourse() {
        return enrolledCourse;
    }

    public boolean addCourse(Course course) {
        return enrolledCourse.add(course);
    }
}
