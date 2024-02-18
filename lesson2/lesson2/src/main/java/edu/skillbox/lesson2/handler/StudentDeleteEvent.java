package edu.skillbox.lesson2.handler;

import org.springframework.context.ApplicationEvent;

import edu.skillbox.lesson2.entity.Student;
import lombok.Getter;

@Getter
public class StudentDeleteEvent extends ApplicationEvent {
    
    private final Student student;

    public StudentDeleteEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
