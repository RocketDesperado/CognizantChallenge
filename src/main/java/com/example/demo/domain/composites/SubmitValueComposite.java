package com.example.demo.domain.composites;

import com.example.demo.domain.model.task.TaskType;

/**
 * Index main form composite. Transfers data to a model and vice versa.
 */
public class SubmitValueComposite {

    private String name;

    private TaskType taskName;

    private String description;

    private String inputParameter;

    public SubmitValueComposite() {
    }

    public SubmitValueComposite(String name, TaskType taskName, String description, String inputParameter) {
        this.name = name;
        this.taskName = taskName;
        this.description = description;
        this.inputParameter = inputParameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskType getTaskName() {
        return taskName;
    }

    public void setTaskName(TaskType taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputParameter() {
        return inputParameter;
    }

    public void setInputParameter(String inputParameter) {
        this.inputParameter = inputParameter;
    }
}
