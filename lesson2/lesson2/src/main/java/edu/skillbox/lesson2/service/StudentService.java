package edu.skillbox.lesson2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import edu.skillbox.lesson2.entity.Student;
import edu.skillbox.lesson2.handler.StudentCreationEvent;
import edu.skillbox.lesson2.handler.StudentDeleteEvent;

import java.util.List;
import java.util.UUID;

@ShellComponent
public class StudentService {
    private List<Student> students;
    private ApplicationEventPublisher publisher;

    StudentService(List<Student> students, ApplicationEventPublisher publisher) {
        this.students = students;
        this.publisher = publisher;
    }

    @ShellMethod(key = "add")
    public void addStudent (String firstName, String lastName, String age) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(Integer.parseInt(age));
        students.add(student);
        publisher.publishEvent(new StudentCreationEvent(this, student));
    }

    @ShellMethod(key="print")
    public void printAll() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }

    @ShellMethod
    public void delete(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (UUID.fromString(id).equals(students.get(i).getId())){
                publisher.publishEvent(new StudentDeleteEvent(this, students.get(i)));
                students.remove(i);
            }
        }
    }

    @ShellMethod(key = "deleteAll")
    public void removeAll () {
        for (int i = 0; i < students.size(); i++ ) {
            students.remove(i);
        }
    }
}
