package com.au.autogen.model;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class ToDoItemValidationError {
    @Valid
    private List<ToDoItemValidationErrorDetails> details;
    private String name;
}

