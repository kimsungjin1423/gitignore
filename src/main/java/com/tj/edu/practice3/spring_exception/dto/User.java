package com.tj.edu.practice3.spring_exception.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class User {
    @NotBlank
    private String name;
    @Min(1)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
