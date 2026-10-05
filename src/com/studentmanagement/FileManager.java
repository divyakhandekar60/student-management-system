package com.studentmanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "students.txt";

    // SAVE ONE NEW STUDENT
    public static void saveStudent(Student student) {

        try {

            FileWriter writer = new FileWriter(FILE_NAME, true);

            writer.write(
                    student.getId() + "," +
                    student.getName() + "," +
                    student.getEmail() + "," +
                    student.getCourse() + "," +
                    student.getMarks() + "\n"
            );

            writer.close();

            System.out.println("Student data saved to file!");

        } catch (IOException e) {

            System.out.println("Error while saving student data.");
        }
    }

    // SAVE ALL STUDENTS
    public static void saveAllStudents(ArrayList<Student> students) {

        try {

            FileWriter writer = new FileWriter(FILE_NAME, false);

            for (Student student : students) {

                writer.write(
                        student.getId() + "," +
                        student.getName() + "," +
                        student.getEmail() + "," +
                        student.getCourse() + "," +
                        student.getMarks() + "\n"
                );
            }

            writer.close();

            System.out.println("File updated successfully!");

        } catch (IOException e) {

            System.out.println("Error while updating file.");
        }
    }

    // LOAD STUDENTS
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String course = data[3];
                double marks = Double.parseDouble(data[4]);

                Student student = new Student(
                        id,
                        name,
                        email,
                        course,
                        marks
                );

                students.add(student);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("No existing student file found.");
        }

        return students;
    }
}