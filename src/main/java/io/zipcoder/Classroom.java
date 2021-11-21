package io.zipcoder;

public class Classroom {
    private int maxNumberOfStudents;
    private Student[] students;

    public Classroom() {
        this.students = new Student[30];
    }

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Classroom(int maxNumberOfStudents, Student[] students) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = students;
    }

    public Student getStudents() {
        return this.students[0];
    }
}
