package com.developer.employeemanagement.entity;

import java.util.Optional;
import java.util.stream.Stream;

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

    public static Optional<Gender> findById(int id) {
        return Stream.of(Gender.values()).filter( f -> f.id == id).findFirst();
    }
}
