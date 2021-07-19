package com.example.demo.domain.model.task;

public enum ResultStatus {
    UNDEFINED("UNDEFINED"),
    SUCCESS("SUCCESS"),
    FAILED("FAILED");

    private String id;

    ResultStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
