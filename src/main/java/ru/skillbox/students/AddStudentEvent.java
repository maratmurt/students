package ru.skillbox.students;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AddStudentEvent extends ApplicationEvent {

    private final String firstName;
    private final String lastName;
    private final int age;

    public AddStudentEvent(Object source, String firstName, String lastName, int age) {
        super(source);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
