package io.zipcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    private int maxNumberOfStudents;
    private Student[] students;

    public Classroom() {
        this.maxNumberOfStudents = 30;
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
        this.maxNumberOfStudents = students.length;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public double getAverageExamScore() {
        Double average = 0.0;
        Integer count = 0;
        for (Student student : students) {
            average += student.getAverageExamScore();
            count++;
        }
        return average/count;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if(this.students[i] == null) {
                this.students[i] = student;
                return;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        Student[] newArray = new Student[students.length];
        int counter = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName().equals(firstName)
                    && students[i].getLastName().equals(lastName)) {
                i++;
            }
            newArray[counter] = students[i];
            counter++;
        }
        students = newArray;
    }

    public Student[] getStudentsByScore() {
        Student[] newArray = new Student[students.length];
        Student temp;

        for(int i = 0; i < students.length; i++) {
            newArray[i] = students[i];
        }

        for(int i = 0; i < newArray.length-1; i++) {
            for (int j = 0; j < newArray.length-i-1; j++) {

                if (newArray[j].getAverageExamScore() < newArray[j+1].getAverageExamScore()) {
                    temp = newArray[j+1]; //temp = dolio
                    newArray[j+1] = newArray[j]; //dolio = leon
                    newArray[j] = temp; //leon = dolio
                }
            }

        }
        return newArray;
    }

    public String getGradeBook() {
        Map<String, ArrayList<Student>> gradeBook = new HashMap<>();
        String[] grades = "ABCDF".split("");

        for (String grade : grades) {
            gradeBook.put(grade, new ArrayList<>());
        }

        Double average = getAverageExamScore();

        for (Student student : students) {
            if (student.getAverageExamScore() >= (average * 2 * 0.9)) {
                gradeBook.get("A").add(student);
            } else if (student.getAverageExamScore() >= (average * 2 * 0.71)) {
                gradeBook.get("B").add(student);
            } else if (student.getAverageExamScore() >= (average * 2 * 0.5)) {
                gradeBook.get("C").add(student);
            } else if (student.getAverageExamScore() >= (average * 2 * 0.11)) {
                gradeBook.get("D").add(student);
            } else {
                gradeBook.get("F").add(student);
            }
        }

        String gradesMap = "";

        for (String grade : gradeBook.keySet()) {
            gradesMap += String.format("\n%2s : %10s", grade, gradeBook.get(grade));
        }

        return gradesMap;
    }
}
