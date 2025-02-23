package com.vouldvell.spring.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Student {

    private String FirstName;
    private String LastName;
    private LocalDate dateOfBirth;
    private String email;
    private int age;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String email) {
        FirstName = firstName;
        LastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {

        int currentMonth = LocalDateTime.now().getMonth().getValue();
        int birthMonth = getDateOfBirth().getMonth().getValue();

        int currentYear = LocalDateTime.now().getYear();
        int birthYear = getDateOfBirth().getYear();

        if(currentMonth > birthMonth){
            int currentDay = LocalDateTime.now().getDayOfMonth();
            int birthDay = getDateOfBirth().getDayOfMonth();
            if(currentDay > birthDay){


                return currentYear - birthYear;
            }
            else{
                return currentYear - birthYear - 1;
            }
        }else{
            return currentYear - birthYear - 1;
        }
    }
}
