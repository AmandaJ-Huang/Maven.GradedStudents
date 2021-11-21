package io.zipcoder;

import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void getAverageExamScoreTest() {
        // Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void addStudentTest() {
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest() {
        // Given
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores1 = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student student1 = new Student("Dolio", "Durant", examScores1);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        classroom.addStudent(student1);
        Student[] postEnrollment = classroom.getStudents();
        classroom.removeStudent("Leon", "Hunter");
        Student[] postExpelled = classroom.getStudents();

        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        String postExpelledAsString = Arrays.toString(postExpelled);

        // Then
        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postExpelledAsString);
    }

    @Test
    public void getStudentsByScoreTest() {
        //Given
        int maxNumberOfStudents = 3;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 50.0, 50.0, 50.0, 50.0 };
        Double[] examScores1 = { 100.0, 100.0, 100.0, 100.0 };
        Double[] examScores2 = { 200.0, 200.0, 200.0, 200.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student student1 = new Student("Dolio", "Durant", examScores1);
        Student student2 = new Student("Kris", "Younger", examScores2);

        //When
        classroom.addStudent(student);
        classroom.addStudent(student1);
        classroom.addStudent(student2);

        Student[] sorted = classroom.getStudentsByScore();

        //Then
        System.out.println(Arrays.toString(sorted));
        System.out.println(sorted.length);
    }


}
