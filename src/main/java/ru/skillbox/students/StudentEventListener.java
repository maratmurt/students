package ru.skillbox.students;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StudentEventListener {

    @EventListener
    public void onAddStudentEvent(AddStudentEvent event) {
        log.info("New student was added: {} {}, {}", event.getFirstName(), event.getLastName(), event.getAge());
    }

    @EventListener
    public void onDeleteStudentEvent(DeleteStudentEvent event) {
        log.info("Student with ID {} was deleted", event.getId());
    }

}
