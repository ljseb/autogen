package com.au.autogen.controller;

import com.au.autogen.model.ToDoItem;
import com.au.autogen.model.ToDoItemAddRequest;
import com.au.autogen.model.ToDoItemUpdateRequest;
import com.au.autogen.service.ToDoService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test/1.0")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @RequestMapping(value = "/todo/{itemId}", produces = "application/json", method = RequestMethod.GET)
    ResponseEntity<ToDoItem> getTodoItemForId(@ApiParam(value = "itemId", required = true) @PathVariable("itemId") Long itemId) {
        try {
            ToDoItem item = toDoService.getTodoItemForId(itemId);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/todo/{id}", produces = {"application/json"}, consumes = {"application/json"}, method = RequestMethod.PATCH)
    ResponseEntity<ToDoItem> updateToDoItem(@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @ApiParam(value = "", required = true)
    @Valid @RequestBody ToDoItemUpdateRequest body) {
        try {
            ToDoItem item = toDoService.updateToDoItem(id, body);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/todo", produces = {"application/json"}, consumes = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<ToDoItem> createToDoItem(@ApiParam(value = "", required = true) @Valid @RequestBody ToDoItemAddRequest body) {
        try {
            ToDoItem item = toDoService.createToDoItem(body);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
