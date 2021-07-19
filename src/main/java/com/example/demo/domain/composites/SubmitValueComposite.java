package com.example.demo.domain.composites;

public class SubmitValueComposite {

    private String name;

    private String taskName;

    private String description;

    private String inputParameter;

    public SubmitValueComposite() {
    }

    public SubmitValueComposite(String name, String taskName, String description, String inputParameter) {
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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
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
