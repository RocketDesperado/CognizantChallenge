package com.example.demo.domain.model.task;

import javax.persistence.Convert;


public enum TaskType {
    FIBONACCI("Fibonacci"),
    BINARY_SEARCH("Binary search");

    private String id;

    TaskType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
