package pquiz1b.enrollment;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private final String code;
    private final String name;
    private final int credits;
    private final List<Student> enrolledStudents;

    public Course(String code, String name, int credits) {
        this(code, name, credits, new ArrayList<>());
    }

    public Course(String code, String name, int credits, List<Student> enrolledStudents) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.enrolledStudents = enrolledStudents;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean addEnrolledStudent(Student student) {
        return enrolledStudents.add(student);
    }
}
