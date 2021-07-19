package com.example.demo.domain.model.task;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TASK_NAME")
    // @Enumerated(EnumType.STRING)
    @Convert(converter = TaskTypeConverter.class)
    private TaskType taskType;

    private String description;

    private String output;

    private Long memory;

    @Column(name = "CPU_TIME")
    private Double cpuTime;

    @Column(name = "SOLUTION_CODE")
    private String solutionCode;

    @Column(name = "STATUS_RESULT")
    @Enumerated(EnumType.STRING)
    private ResultStatus statusResult;

    public Task() {
        // def constr
    }

    public Task(TaskType taskType, String description, String output, Long memory, Double cpuTime, String solutionCode, ResultStatus statusResult) {
        this.taskType = taskType;
        this.description = description;
        this.output = output;
        this.memory = memory;
        this.cpuTime = cpuTime;
        this.solutionCode = solutionCode;
        this.statusResult = statusResult;
    }

    public Long getId() {
        return id;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public String getDescription() {
        return description;
    }

    public String getOutput() {
        return output;
    }

    public Long getMemory() {
        return memory;
    }

    public Double getCpuTime() {
        return cpuTime;
    }

    public String getSolutionCode() {
        return solutionCode;
    }

    public ResultStatus getStatusResult() {
        return statusResult;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskType='" + taskType + '\'' +
                ", description='" + description + '\'' +
                ", output='" + output + '\'' +
                ", memory=" + memory +
                ", cpuTime=" + cpuTime +
                ", solutionCode='" + solutionCode + '\'' +
                ", statusResult='" + statusResult + '\'' +
                '}';
    }
}
