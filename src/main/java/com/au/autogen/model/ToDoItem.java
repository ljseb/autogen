package com.au.autogen.model;

import lombok.Data;

@Data
public class ToDoItem {
    private Long id;
    private String text;
    private Boolean isCompleted;
    private String createdAt;

}

