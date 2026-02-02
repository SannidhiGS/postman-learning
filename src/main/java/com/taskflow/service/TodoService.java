package com.taskflow.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.taskflow.entity.Todo;
import com.taskflow.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public Todo createTodo(Todo todo) {
        todo.setStatus("PENDING");
        return repo.save(todo);
    }

    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    public Todo getTodoById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public Todo updateTodo(Long id, Todo todo) {
        Todo existing = getTodoById(id);
        existing.setTitle(todo.getTitle());
        existing.setDescription(todo.getDescription());
        existing.setPriority(todo.getPriority());
        return repo.save(existing);
    }

    public void deleteTodo(Long id) {
        repo.deleteById(id);
    }

    public Todo updateStatus(Long id, String status) {
        Todo todo = getTodoById(id);
        todo.setStatus(status);
        return repo.save(todo);
    }

    public List<Todo> getByStatus(String status) {
        return repo.findByStatus(status);
    }

    public List<Todo> getByPriority(String priority) {
        return repo.findByPriority(priority);
    }

    public List<Todo> search(String keyword) {
        return repo.findByTitleContaining(keyword);
    }
}
