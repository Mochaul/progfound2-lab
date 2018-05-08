package pquiz1b.enrollment;

public class Student {

    private final String id;
    private final int enrollYear;
    private final String degree;

    public Student(String id, int enrollYear, String degree) {
        this.id = id;
        this.enrollYear = enrollYear;
        this.degree = degree;
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
}
