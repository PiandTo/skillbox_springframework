package edu.skillbox.lesson2.handler;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import edu.skillbox.lesson2.entity.Student;
import lombok.Getter;

@Getter
public class StudentCreationEvent extends ApplicationEvent{

    private final Student student;
    
    public StudentCreationEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
