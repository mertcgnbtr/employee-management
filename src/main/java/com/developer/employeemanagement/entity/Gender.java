package com.developer.employeemanagement.entity;

public enum Gender {

    MALE(1),
    FEMALE(2);

    private int id;

    Gender(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
