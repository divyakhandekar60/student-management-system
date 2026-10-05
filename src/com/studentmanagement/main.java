package com.studentmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        Scanner sc = new Scanner(System.in);

        while (true) {

            try {

                System.out.println(
                        "\n===== Student Management System ====="
                );

                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                // ADD
                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    // ID validation
                    if (id <= 0) {
                        System.out.println("Student ID must be greater than 0!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    // Name validation
                    if (name.trim().isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    // Email validation
                    if (!email.contains("@") || !email.contains(".")) {
                        System.out.println("Invalid email format!");
                        break;
                    }

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    if (course.trim().isEmpty()) {
                        System.out.println("Course cannot be empty!");
                        break;
                    }

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    // Marks validation
                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100!");
                        break;
                    }

                    Student student = new Student(
                            id,
                            name,
                            email,
                            course,
                            marks
                    );

                    service.addStudent(student);

                    break;

                // VIEW
                case 2:

                    service.viewStudents();

                    break;

                // SEARCH
                case 3:

                    System.out.print("Enter Student ID: ");

                    int searchId = sc.nextInt();

                    service.searchStudentById(searchId);

                    break;

                // UPDATE
                case 4:

                    System.out.print(
                            "Enter Student ID to update: "
                    );

                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("Enter New Marks: ");
                    double newMarks = sc.nextDouble();

                    if (newMarks < 0 || newMarks > 100) {

                        System.out.println(
                                "Marks must be between 0 and 100!"
                        );

                        break;
                    }

                    service.updateStudent(
                            updateId,
                            newName,
                            newEmail,
                            newCourse,
                            newMarks
                    );

                    break;

                // DELETE
                case 5:

                    System.out.print(
                            "Enter Student ID to delete: "
                    );

                    int deleteId = sc.nextInt();

                    service.deleteStudent(deleteId);

                    break;

                // EXIT
                case 6:

                    System.out.println(
                            "Thank you for using Student Management System!"
                    );

                    sc.close();

                    return;

                default:

                    System.out.println(
                            "Invalid choice! Please enter 1 to 6."
                    );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input! Please enter the correct data type."
                );

                sc.nextLine();
            }
        }
    }
}