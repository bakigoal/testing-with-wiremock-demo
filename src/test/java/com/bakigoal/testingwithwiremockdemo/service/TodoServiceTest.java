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
@AutoConfigureWireMock(port = 0, stubs = "classpath:/stubs/todo-service")
@TestPropertySource(properties = {
    "todos.url=http://localhost:${wiremock.server.port}"
})
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    void test1() {
        Todo todo = todoService.test();
        assertEquals("Todo 1",todo.getTitle());
        assertFalse(todo.isCompleted());
        assertEquals(1L, todo.getId());
        assertEquals(1L, todo.getUserId());
    }

}