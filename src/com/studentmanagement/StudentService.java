package com.studentmanagement;

import java.util.ArrayList;

public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    // CONSTRUCTOR
    public StudentService() {

        students = FileManager.loadStudents();

        System.out.println(
                students.size() + " student(s) loaded from file."
        );
    }

 // ADD STUDENT
    public void addStudent(Student student) {

        // Check duplicate ID
        for (Student s : students) {

            if (s.getId() == student.getId()) {

                System.out.println(
                        "Student ID already exists!"
                );

                return;
            }
        }

        students.add(student);

        FileManager.saveStudent(student);

        System.out.println(
                "Student added successfully!"
        );
    }

    // VIEW STUDENTS
    public void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found!");

            return;
        }

        for (Student student : students) {

            System.out.println(student);
        }
    }

    // SEARCH STUDENT BY ID
    public void searchStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("Student Found!");
                System.out.println(student);

                return;
            }
        }

        System.out.println("Student not found!");
    }

    // UPDATE STUDENT
    public void updateStudent(
            int id,
            String name,
            String email,
            String course,
            double marks) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(name);
                student.setEmail(email);
                student.setCourse(course);
                student.setMarks(marks);

                // Update file
                FileManager.saveAllStudents(students);

                System.out.println(
                        "Student details updated successfully!"
                );

                return;
            }
        }

        System.out.println("Student not found!");
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        boolean removed = students.removeIf(
                student -> student.getId() == id
        );

        if (removed) {

            // Update file
            FileManager.saveAllStudents(students);

            System.out.println(
                    "Student deleted successfully!"
            );

        } else {

            System.out.println("Student not found!");
        }
    }
}