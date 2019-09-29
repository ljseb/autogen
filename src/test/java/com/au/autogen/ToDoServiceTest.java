package com.au.autogen;

import com.au.autogen.model.ToDoItem;
import com.au.autogen.model.ToDoItemAddRequest;
import com.au.autogen.model.ToDoItemUpdateRequest;
import com.au.autogen.service.ToDoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoServiceTest {

    @InjectMocks
    ToDoService toDoService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldGetTodoItemForIdSuccessfully() throws Exception {
        ToDoItem item = toDoService.getTodoItemForId(1L);
        assertEquals(java.util.Optional.of(1L).get(), item.getId());
        assertEquals("Some text ideally from DB1", item.getText());
        assertTrue(item.getIsCompleted());
    }

    @Test
    public void shouldUpdateTodoItemForIdSuccessfully() throws Exception {
        ToDoItemUpdateRequest req = new ToDoItemUpdateRequest();
        req.setText("Jon");
        req.setIsCompleted(true);
        ToDoItem item = toDoService.updateToDoItem(101L, req);
        assertEquals(java.util.Optional.of(101L).get(), item.getId());
        assertEquals("Jon", item.getText());
        assertTrue(item.getIsCompleted());
    }

    @Test
    public void shouldAddTodoItemForIdSuccessfully() throws Exception {
        ToDoItemAddRequest req = new ToDoItemAddRequest();
        req.setText("Jonny");
        ToDoItem item = toDoService.createToDoItem(req);
        assertEquals(java.util.Optional.of(1000L).get(), item.getId());
        assertEquals("Jonny", item.getText());
        assertTrue(item.getIsCompleted());
    }
}
