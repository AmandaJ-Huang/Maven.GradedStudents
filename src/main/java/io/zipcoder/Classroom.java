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
}
