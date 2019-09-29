package com.au.autogen.service;

import com.au.autogen.model.ToDoItem;
import com.au.autogen.model.ToDoItemAddRequest;
import com.au.autogen.model.ToDoItemUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ToDoService {

    //retrieve To-do item
    public ToDoItem getTodoItemForId(Long id) throws Exception {
        ToDoItem item = new ToDoItem();
        item.setId(id);
        item.setText("Some text ideally from DB" + id);
        item.setIsCompleted(true);
        item.setCreatedAt("Some date from DB" + id);
        return item;
    }

    //update To-do item
    public ToDoItem updateToDoItem(Long id, ToDoItemUpdateRequest request) throws Exception {
        ToDoItem item = new ToDoItem();
        item.setId(id);
        item.setText(request.getText());
        item.setIsCompleted(true);
        return item;
    }

    //create To-do item - Id is hardcoded as 1000 for now.
    public ToDoItem createToDoItem(ToDoItemAddRequest request) throws Exception {
        ToDoItem item = new ToDoItem();
        item.setId(1000L);
        item.setText(request.getText());
        item.setIsCompleted(true);
        item.setCreatedAt(new Date().toString());
        return item;
    }
}
