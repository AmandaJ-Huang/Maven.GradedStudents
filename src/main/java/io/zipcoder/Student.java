package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Boolean equals(Student student) {
        if (student.getFirstName().equals(this.firstName)
                && student.getLastName().equals(this.lastName)) {
            return true;
        }
        return false;
    }

    public String getExamScores() {
        String output = "";
        for (int i = 0; i < examScores.size(); i++) {
            output += "\nExam " + (i+1) + " -> " + examScores.get(i);
        }
        return "Exam Scores:" + output;
    }

    public Integer getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber-1, newScore);
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        Integer size = examScores.size();

        for (Double score : examScores) {
            sum += score;
        }

        return sum/size;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("> Student Name: " + firstName + " " + lastName)
                .append("\n> "  + getExamScores())
                .toString();
    }
}
