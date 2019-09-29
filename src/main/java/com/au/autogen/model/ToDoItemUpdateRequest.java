package com.au.autogen.model;

import lombok.Data;

@Data
public class ToDoItemUpdateRequest {
    private String text;
    private Boolean isCompleted;

}

