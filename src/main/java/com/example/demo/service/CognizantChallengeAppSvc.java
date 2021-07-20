package com.example.demo.service;

import com.example.demo.domain.composites.RequestCompilerJson;
import com.example.demo.domain.composites.ResponseCompilerJson;
import com.example.demo.domain.composites.SubmitValueComposite;
import com.example.demo.domain.model.person.Person;
import com.example.demo.domain.model.person.PersonsRepository;
import com.example.demo.domain.model.task.*;
import com.example.demo.service.jdoodleservice.CodeExecutionAppSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CognizantChallengeAppSvc {

    private PersonsRepository personsRepository;

    private TaskRepository taskRepository;

    private CodeExecutionAppSvc codeExecutionAppSvc;

    private CognizantChallengeAppSvcHelper cognizantChallengeAppSvcHelper;

    @Autowired
    public CognizantChallengeAppSvc(
            PersonsRepository personsRepository,
            CodeExecutionAppSvc codeExecutionAppSvc,
            TaskRepository taskRepository,
            CognizantChallengeAppSvcHelper cognizantChallengeAppSvcHelper) {
        this.personsRepository = personsRepository;
        this.codeExecutionAppSvc = codeExecutionAppSvc;
        this.taskRepository = taskRepository;
        this.cognizantChallengeAppSvcHelper = cognizantChallengeAppSvcHelper;
    }

    /**
     * Read all persons from DB and convert it into the list
     * @return
     */
    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<>();
        Iterator<Person> personIterable = personsRepository.findAll().iterator();
        while (personIterable.hasNext()) {
            personList.add(personIterable.next());
        }
        return personList;
    }

    /**
     * Creates whether new Person or use existing one by Name. Basically, Name should be unique.
     * Executes remote call for the solution and creates Task entity.
     * @param valueComposite
     */
    public void addPersonWithTask(SubmitValueComposite valueComposite) {
        ResponseCompilerJson responseCompilerJson = codeExecutionAppSvc.execute(new RequestCompilerJson(valueComposite.getInputParameter()));

        List<Person> personList = personsRepository.findByName(valueComposite.getName(), Person.class)
                .stream().collect(Collectors.toList());

        Person person = personList.isEmpty() ? new Person(valueComposite.getName()) : personList.get(0);

        Task task = new Task(
                valueComposite.getTaskName(),
                valueComposite.getDescription(),
                responseCompilerJson.getOutput(),
                responseCompilerJson.getMemory(),
                responseCompilerJson.getCpuTime(),
                valueComposite.getInputParameter(),
                cognizantChallengeAppSvcHelper.defineResultStatus(valueComposite.getTaskName(), responseCompilerJson.getOutput())
        );

        person.addTask(task);
        personsRepository.save(person);
    }
}
