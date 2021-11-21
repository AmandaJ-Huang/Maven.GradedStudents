package io.zipcoder;

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
        for (int i = 0; i < maxNumberOfStudents; i++) {
            this.students[i] = student;
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
}
