// Code by : Kiran
// Task 3 : Student management system

import java.util.Scanner;
public class StudentManagementSystemUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner, sms);
                    break;
                case 2:
                    removeStudent(scanner, sms);
                    break;
                case 3:
                    searchStudent(scanner, sms);
                    break;
                case 4:
                    displayAllStudents(sms);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.println("\n===== Add Student =====");
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter grade: ");
        String grade = scanner.next();

        if (name.trim().isEmpty() || grade.trim().isEmpty()) {
            System.out.println("Name and grade cannot be empty.");
            return;
        }

        Student newStudent = new Student(name, rollNumber, grade);
        sms.addStudent(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.println("\n===== Remove Student =====");
        System.out.print("Enter the name of the student to remove: ");
        String name = scanner.next();

        Student studentToRemove = sms.searchStudent(name);
        if (studentToRemove == null) {
            System.out.println("Student not found.");
        } else {
            sms.removeStudent(studentToRemove);
            System.out.println("Student removed successfully!");
        }
    }

    private static void searchStudent(Scanner scanner, StudentManagementSystem sms) {
        System.out.println("\n===== Search Student =====");
        System.out.print("Enter the name of the student to search for: ");
        String name = scanner.next();

        Student foundStudent = sms.searchStudent(name);
        if (foundStudent == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found: " + foundStudent);
        }
    }

    private static void displayAllStudents(StudentManagementSystem sms) {
        System.out.println("\n===== All Students =====");
        sms.displayAllStudents();
    }
}
