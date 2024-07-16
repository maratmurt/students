package ru.skillbox.students;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty("app.data-initializer.enabled")
public class DataInitializer {

    private final StudentService service;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent() {
        service.add("John", "Smith", 20);
        service.add("Steve", "Jackson", 22);
        service.add("Ben", "Johnson", 19);
    }

}
