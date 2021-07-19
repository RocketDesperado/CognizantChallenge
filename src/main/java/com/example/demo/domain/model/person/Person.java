package com.example.demo.domain.model.person;

import com.example.demo.domain.model.task.Task;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "PERSON_TASK",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    Set<Task> listOfTasks;

    public Person() {
        // def constr
    }

    public Person(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        if (listOfTasks == null) {
            listOfTasks = new HashSet<>();
        }
        listOfTasks.add(task);
    }

    public Set<Task> getListOfTasks() {
        return listOfTasks;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
