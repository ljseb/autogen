package com.au.autogen;

import com.au.autogen.model.BalanceTestResult;
import com.au.autogen.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {
    @InjectMocks
    TaskService taskService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldValidateBracketsSuccessfullyWithText() throws Exception {
        BalanceTestResult result = taskService.validateBrackets("racecar");
        assertEquals("racecar", result.getInput());
        assertTrue(result.getIsBalanced());
    }

    @Test
    public void shouldValidationFail() throws Exception {
        BalanceTestResult result = taskService.validateBrackets("({[]}])");
        assertEquals("({[]}])", result.getInput());
        assertFalse(result.getIsBalanced());
    }
}
