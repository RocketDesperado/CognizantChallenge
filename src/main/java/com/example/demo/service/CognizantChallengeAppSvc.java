package com.example.demo.service;

import com.example.demo.domain.composites.RequestCompilerJson;
import com.example.demo.domain.composites.ResponseCompilerJson;
import com.example.demo.domain.composites.SubmitValueComposite;
import com.example.demo.domain.model.person.Person;
import com.example.demo.domain.model.person.PersonsRepository;
import com.example.demo.domain.model.task.*;
import com.example.demo.service.jdoodleservice.CodeAppSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CognizantChallengeAppSvc {

    private PersonsRepository personsRepository;

    private TaskRepository taskRepository;

    private CodeAppSvc codeAppSvc;

    private CognizantChallengeAppSvcHelper cognizantChallengeAppSvcHelper;

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    @Autowired
    public CognizantChallengeAppSvc(
            PersonsRepository personsRepository,
            CodeAppSvc codeAppSvc,
            TaskRepository taskRepository,
            CognizantChallengeAppSvcHelper cognizantChallengeAppSvcHelper) {
        this.personsRepository = personsRepository;
        this.codeAppSvc = codeAppSvc;
        this.taskRepository = taskRepository;
        this.cognizantChallengeAppSvcHelper = cognizantChallengeAppSvcHelper;
    }

    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<>();
        Iterator<Person> personIterable = personsRepository.findAll().iterator();
        while (personIterable.hasNext()) {
            personList.add(personIterable.next());
        }
        return personList;
    }

    /**
     * Get all task from the repo and distinct it by Task Name. This and description using for model UI mapping purposes.
     *
     * @return
     */
    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();
        Iterator<Task> taskIterable = taskRepository.findAll().iterator();
        while (taskIterable.hasNext()) {
            taskList.add(taskIterable.next());
        }
        return taskList.stream().filter(distinctByKey(Task::getTaskType)).collect(Collectors.toList());
    }


    public void addPersonWithTask(SubmitValueComposite valueComposite) {
        ResponseCompilerJson responseCompilerJson = codeAppSvc.execute(new RequestCompilerJson(valueComposite.getInputParameter()));

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
