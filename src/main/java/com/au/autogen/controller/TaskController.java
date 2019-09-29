package com.au.autogen.controller;

import com.au.autogen.model.BalanceTestResult;
import com.au.autogen.model.ToDoItemValidationError;
import com.au.autogen.service.TaskService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/test/1.0")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = BalanceTestResult.class),
            @ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class)
    })
    @RequestMapping(value = "/tasks/validateBrackets", produces = "application/json", method = RequestMethod.GET)
    ResponseEntity<BalanceTestResult> tasksValidateBracketsGet(@NotNull @Size(min = 1, max = 100)
                                                               @Valid @RequestParam(required = true) String input) {
        try {
            BalanceTestResult result = taskService.validateBrackets(input);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
