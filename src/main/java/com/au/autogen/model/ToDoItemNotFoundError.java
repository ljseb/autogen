package com.au.autogen.model;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class ToDoItemNotFoundError {
    @Valid
    private List<ToDoItemNotFoundErrorDetails> details;
    private String name;


}

