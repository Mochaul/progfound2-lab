package pquiz1.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;

import pquiz1.enrollment.*;

public class RecordsReader implements CsvReader{
    Path file;
    List<String> lines;
    ArrayList<Student> students;
    ArrayList<Course> courses;
    
    public RecordsReader(Path file) throws IOException{
        this.file = file;
        this.lines = Files.readAllLines(this.file, StandardCharsets.UTF_8);
        this.lines.remove(0); // removes first line
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.loadStudents();
    }
    
    private void loadStudents(){
        for(String line : this.lines){
            String[] arr = line.split(",");
            int index = this.indexOfStudent(arr[0]);
            if (index != -1){
                // if student found, add course only
                this.students.get(index).addCourse(new Course(arr[3], arr[4], Integer.parseInt(arr[5])));          
            }else{
                // else create student and add course
                this.students.add(new Student(arr[0], Integer.parseInt(arr[1]), arr[2], new ArrayList<>()));
                this.students.get(this.indexOfStudent(arr[0])).addCourse(new Course(arr[3], arr[4], Integer.parseInt(arr[5])));
            }
        }
    }

    /**
     * Returns index of student with id {@code id} in {@code students}
     * 
     * @param id
     * @return
     */
    private int indexOfStudent(String id){
        for (int i=0; i<this.students.size(); i++){
            if (this.students.get(i).getId().equals(id)) return i;
        }
        return -1;
    }

    /**
     * Returns list of unique students.
     *
     * @return
     */
    public List<Student> getStudents(){
        return this.students;
    }

    /**
     * Returns list of unique students enrolled in a given course.
     *
     * @param courseName
     * @return
     */
    public List<Student> getStudentsEnrolledInCourse(String courseName){
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : this.students){
            if (s.hasCourse(courseName)) result.add(s);
        }
        return result;
    }

    /**
     * Returns list of unique students enrolled in a given year.
     * @param year
     * @return
     */
    public List<Student> getStudentsByEnrollYear(int year){
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : this.students){
            if (s.getEnrollYear() == year) result.add(s);
        }
        return result;
    }
}