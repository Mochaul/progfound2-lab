import pquiz1.enrollment.Student;
import pquiz1.reader.CsvReader;
import pquiz1.reader.RecordsReader;
import java.nio.file.FileSystems;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class is the main program for programming quiz 1.
 *
 * @author TODO Write your name & NPM here
 */
public class PQuiz1 {

    private static Path cwd = Paths.get("pquiz_1");

    public static void main(String[] args) throws IOException{
        // Create a reference to the data file as instance of Path object
        Path dataFile = cwd.resolve("data/uni-x-students.csv");
        Path path = FileSystems.getDefault().getPath("./../../../data", "uni-x-students.csv");
        
        // create reader object
        CsvReader reader = new RecordsReader(path);

        List<Student> students = reader.getStudents();
        System.out.println(String.format("There are %d unique students in the records",
                students.size()));

        List<Student> studentsWhoTakeKimiaDasar = reader.getStudentsEnrolledInCourse("Kimia Dasar");
        System.out.println(String.format("There are %d unique students that are taking Kimia Dasar",
                studentsWhoTakeKimiaDasar.size()));

        List<Student> studentsEnrolledIn2014 = reader.getStudentsByEnrollYear(2014);
        System.out.println(String.format("There are %d unique students that enrolled in 2014",
                studentsEnrolledIn2014.size()));

        // Reserved for demo with TA/lecturer

        // End of reserved section
    }
}
