import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Student> students;
    private String dataFile = "student_data.txt";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudentData();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentData();
    }

    public void removeStudent(Student student) {
        students.remove(student);
        saveStudentData();
    }

    public Student searchStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void loadStudentData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            // If the file does not exist, it means no data has been saved yet, so no need to handle this exception.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading student data: " + e.getMessage());
        }
    }

    private void saveStudentData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }
}
