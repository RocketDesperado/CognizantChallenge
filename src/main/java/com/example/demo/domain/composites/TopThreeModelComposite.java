package com.example.demo.domain.composites;

import com.example.demo.domain.model.task.TaskType;

import java.util.List;

public class TopThreeModelComposite {

    private String name;

    private Long successSolutionsCount;

    private List<String> taskTypeList;

    public TopThreeModelComposite() {
    }

    public TopThreeModelComposite(String name, Long successSolutions, List<String> taskTypeList) {
        this.name = name;
        this.successSolutionsCount = successSolutions;
        this.taskTypeList = taskTypeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSuccessSolutionsCount() {
        return successSolutionsCount;
    }

    public void setSuccessSolutionsCount(Long successSolutionsCount) {
        this.successSolutionsCount = successSolutionsCount;
    }

    public List<String> getTaskTypeList() {
        return taskTypeList;
    }

    public void setTaskTypeList(List<String> taskTypeList) {
        this.taskTypeList = taskTypeList;
    }
}
