package com.au.autogen.model;

import lombok.Data;

@Data
public class ToDoItemValidationErrorDetails {
    private String location;
    private String param;
    private String msg;
    private String value;
}

