package ru.skillbox.students;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class StudentsShell {
    private final StudentService service;

    @ShellMethod(key = "show all")
    public String showAll() {
        return service.showAll();
    }

    @ShellMethod(key = "add")
    public String add(@ShellOption("f") String firstName,
                      @ShellOption("l") String lastName,
                      @ShellOption("a") int age) {
        int id = service.add(firstName, lastName, age);
        return "Added new student with ID " + id;
    }

    @ShellMethod(key = "delete")
    public String delete(@ShellOption("id") int id) {
        service.delete(id);
        return "Deleted student with ID " + id;
    }

    @ShellMethod(key = "delete all")
    public String deleteAll() {
        service.deleteAll();
        return "Deleted all students";
    }
}
