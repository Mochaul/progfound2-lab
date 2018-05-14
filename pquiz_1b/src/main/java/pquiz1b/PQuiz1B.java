package pquiz1b;

import pquiz1b.enrollment.Course;
import pquiz1b.enrollment.Student;
import pquiz1b.reader.CsvReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class is the main program for programming quiz 1 (make-up).
 *
 * @author TODO Write your name & NPM here
 */
public class PQuiz1B {

    private static Path cwd = Paths.get("pquiz_1b");

    public static void main(String[] args) throws IOException {
        // Create a reference to the data file as instance of Path object
        Path dataFile = cwd.resolve("data/uni-x-students.csv");

        /* TODO: Create an instance of class that implements CsvReader and
           reads the CSV data from the file referred by dataFile */
        CsvReader reader = null;

        List<Course> courses = reader.getCourses();
        System.out.println(String.format("There are %d unique courses in the records",
                courses.size()));

        List<Student> studentsWhoTakeKimiaDasar = reader.getStudentsEnrolledInCourse("Kimia Dasar");
        System.out.println(String.format("There are %d unique students that are taking Kimia Dasar",
                studentsWhoTakeKimiaDasar.size()));

        List<Student> students2016inKalkulusI = reader.getStudentsEnrolledInCourseByYear("Kalkulus I",
                2016);
        System.out.println(String.format("There are %d from batch year 2016 that enrolled in Kalkulus I",
                students2016inKalkulusI.size()));

        // Reserved for demo with TA/lecturer

        // End of reserved section
    }
}
