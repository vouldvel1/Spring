package com.vouldvell.spring.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;


public class Student {

    private int id;

    private String login;
    private String password;

    private String firstName = "FirstName";
    private String lastName = "LastName";

    private LocalDate dateOfBirth =  LocalDate.now();
    private String email = "email";

    private int age = 0;

    public Student(String login, String password) {
        id = new Random().nextInt(0, 5000000);
        this.login = login;
        this.password = password;
    }

    public void SetInfo(String firstName, String lastName, LocalDate dateOfBirth, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
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
