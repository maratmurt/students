package ru.skillbox.students;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final Map<Integer, Student> students;
    private int count;
    private final ApplicationEventPublisher publisher;

    public String showAll() {
        return students.values()
                .stream()
                .map(Student::toString)
                .collect(Collectors.joining("\n"));
    }

    public int add(String firstName, String lastName, int age) {
        Student student = new Student();
        student.setId(count);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        students.put(count, student);
        publisher.publishEvent(new AddStudentEvent(this, firstName, lastName, age));
        return count++;
    }

    public void delete(int id) {
        students.remove(id);
        publisher.publishEvent(new DeleteStudentEvent(this, id));
    }

    public void deleteAll() {
        students.clear();
    }
}
