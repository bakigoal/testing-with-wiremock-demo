package com.bakigoal.testingwithwiremockdemo.service;

import com.bakigoal.testingwithwiremockdemo.dto.Todo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TodoService {

    @Value("${todos.url}")
    private String baseUrl;

    public Todo test() {
        var responseEntity = new RestTemplate().exchange(
                baseUrl + "/todos/1", HttpMethod.GET, null, Todo.class);
        return responseEntity.getBody();
    }
}
