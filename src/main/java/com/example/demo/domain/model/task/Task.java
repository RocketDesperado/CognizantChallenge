package com.example.demo.domain.model.task;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TASK_NAME")
    private String taskName;

    private String description;

    private String output;

    private Long memory;

    @Column(name = "CPU_TIME")
    private Double cpuTime;

    @Column(name = "SOLUTION_CODE")
    private String solutionCode;

    public Task() {
        // def constr
    }

    public Task(String taskName, String description, String output, Long memory, Double cpuTime, String solutionCode) {
        this.taskName = taskName;
        this.description = description;
        this.output = output;
        this.memory = memory;
        this.cpuTime = cpuTime;
        this.solutionCode = solutionCode;
    }

    public Long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
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

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", output='" + output + '\'' +
                ", memory=" + memory +
                ", cpuTime=" + cpuTime +
                ", solutionCode='" + solutionCode + '\'' +
                '}';
    }
}
