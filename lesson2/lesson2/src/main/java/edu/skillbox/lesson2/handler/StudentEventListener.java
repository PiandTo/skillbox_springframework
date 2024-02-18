package edu.skillbox.lesson2.handler;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener {
    
    @EventListener
    public void listen(StudentCreationEvent event) {
        System.out.println("Student created" + " " + event.getStudent().toString());
    }

    @EventListener
    public void delete(StudentDeleteEvent event) {
        System.out.println("Student delete" + " " + event.getStudent().toString());
    }
}
