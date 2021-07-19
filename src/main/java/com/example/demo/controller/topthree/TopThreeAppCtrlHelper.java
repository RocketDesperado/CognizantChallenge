package com.example.demo.controller.topthree;

import com.example.demo.domain.composites.TopThreeModelComposite;
import com.example.demo.domain.model.person.Person;
import com.example.demo.domain.model.task.ResultStatus;
import com.example.demo.domain.model.task.Task;
import com.example.demo.domain.model.task.TaskType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TopThreeAppCtrlHelper {

    public List<TopThreeModelComposite> topThreeModelCompositeList(List<Person> personList) {
        List<TopThreeModelComposite> modelCompositeList = new ArrayList<>();
        personList.forEach(person -> {
            TopThreeModelComposite composite = new TopThreeModelComposite();
            composite.setName(person.getName());
            composite.setSuccessSolutionsCount(countSuccessSolutions(person));
            composite.setTaskTypeList(listSuccessTaskSolutions(person));
            modelCompositeList.add(composite);
        });
        return sortByHighestSolutionScore(modelCompositeList);
    }

    private Long countSuccessSolutions(Person person) {
        return person.getListOfTasks().stream()
                .filter(task -> ResultStatus.SUCCESS.equals(task.getStatusResult()))
                .count();
    }

    private List<String> listSuccessTaskSolutions(Person person) {
        return person.getListOfTasks().stream()
                .filter(task -> ResultStatus.SUCCESS.equals(task.getStatusResult()))
                .map(Task::getTaskType)
                .filter(Objects::nonNull)
                .map(TaskType::getId)
                .collect(Collectors.toList());
    }

    private List<TopThreeModelComposite> sortByHighestSolutionScore(List<TopThreeModelComposite> modelCompositeList) {
        return modelCompositeList.stream().sorted((o1, o2)->o1.getSuccessSolutionsCount().
                compareTo(o2.getSuccessSolutionsCount())).
                collect(Collectors.toList());
    }

}
