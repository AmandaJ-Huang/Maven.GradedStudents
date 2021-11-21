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

    public String getExamScores() {
        String output = "";
        for (int i = 0; i < examScores.size(); i++) {
            output += "\nExam " + (i+1) + " -> " + examScores.get(i);
        }
        return "Exam Scores:\n" + output;
    }

    public Integer getNumberOfExamsTaken() {
        return this.examScores.size();
    }

}
