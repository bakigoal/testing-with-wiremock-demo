package com.bakigoal.testingwithwiremockdemo.service;

import com.bakigoal.testingwithwiremockdemo.dto.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
@TestPropertySource(properties = {
    "todos.url=http://localhost:${wiremock.server.port}"
})
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    void todoServiceTest() {
        Todo todo1 = todoService.test(1L);
        assertEquals("Todo 1",todo1.getTitle());
        assertFalse(todo1.isCompleted());
        assertEquals(1L, todo1.getId());
        assertEquals(1L, todo1.getUserId());


        Todo todo2 = todoService.test(2L);
        assertEquals("Todo 2",todo2.getTitle());
        assertFalse(todo2.isCompleted());
        assertEquals(2L, todo2.getId());
        assertEquals(2L, todo2.getUserId());
    }

}