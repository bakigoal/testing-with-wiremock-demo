package com.bakigoal.testingwithwiremockdemo.controller;

import com.bakigoal.testingwithwiremockdemo.dto.Todo;
import com.bakigoal.testingwithwiremockdemo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/{id}")
    public Todo test(@PathVariable Long id) {
        return todoService.test(id);
    }
}
