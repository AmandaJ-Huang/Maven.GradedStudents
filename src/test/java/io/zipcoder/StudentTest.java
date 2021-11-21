package io.zipcoder;

import org.junit.Test;

public class StudentTest {

    @Test
    public void getExamScoresTest(){
        //Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student (firstName, lastName, examScores);

        //When
        String output = student.getExamScores();

        //Then
        System.out.println(output);
    }

}