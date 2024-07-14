package ru.skillbox.students;

import lombok.Data;

@Data
public class Student {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    @Override
    public String toString() {
        return id + " - " + firstName + " " + lastName + ", " + age;
    }
}
