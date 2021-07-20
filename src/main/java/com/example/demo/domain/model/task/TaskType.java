package com.example.demo.domain.model.task;

import javax.persistence.Convert;


public enum TaskType {
    FIBONACCI("Fibonacci"),
    IS_PALINDROME("Palindrome"),
    REVERSE_STRING("Reverse String");

    private String id;

    TaskType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
