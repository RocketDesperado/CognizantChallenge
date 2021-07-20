package com.example.demo.controller.topthree;

import com.example.demo.domain.composites.TopThreeModelComposite;
import com.example.demo.domain.model.person.Person;
import com.example.demo.domain.model.task.ResultStatus;
import com.example.demo.domain.model.task.Task;
import com.example.demo.domain.model.task.TaskType;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
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
                .filter(distinctByKey(x -> x.getTaskType()))
                .count();
    }

    private List<String> listSuccessTaskSolutions(Person person) {
        return person.getListOfTasks().stream()
                .filter(task -> ResultStatus.SUCCESS.equals(task.getStatusResult()))
                .map(Task::getTaskType)
                .filter(Objects::nonNull)
                .map(TaskType::getId)
                .distinct()
                .collect(Collectors.toList());
    }


    private List<TopThreeModelComposite> sortByHighestSolutionScore(List<TopThreeModelComposite> modelCompositeList) {
        // TODO: enhance sort when solution count is the same
        Comparator<TopThreeModelComposite> comparator = (o1, o2)->o2.getSuccessSolutionsCount().compareTo(o1.getSuccessSolutionsCount());
        return modelCompositeList.stream()
                .filter(comp -> comp.getSuccessSolutionsCount() > 0)
                .sorted(comparator)
                .collect(Collectors.toList())
                .subList(0, 3);
    }

    private <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
