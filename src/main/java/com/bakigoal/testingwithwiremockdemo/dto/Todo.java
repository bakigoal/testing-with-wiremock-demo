package com.bakigoal.testingwithwiremockdemo.dto;

import lombok.Data;

@Data
public class Todo {
    private Long id;
    private Long userId;
    private String title;
    private boolean completed;
}
