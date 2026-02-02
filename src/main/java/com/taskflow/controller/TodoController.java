package com.taskflow.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.taskflow.entity.Todo;
import com.taskflow.service.TodoService;
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }
    // 1️⃣ Create Todo
    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return service.createTodo(todo);
    }

    // 2️⃣ Get All Todos
    @GetMapping
    public List<Todo> getAll() {
        return service.getAllTodos();
    }

    // 3️⃣ Get Todo by ID
    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id) {
        return service.getTodoById(id);
    }

    // 4️⃣ Update Todo
    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id,
                       @RequestBody Todo todo) {
        return service.updateTodo(id, todo);
    }

    // 5️⃣ Delete Todo
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteTodo(id);
        return "Todo deleted successfully";
    }

    // 6️⃣ Update Status
    @PatchMapping("/{id}/status")
    public Todo updateStatus(@PathVariable Long id,
                             @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    // 7️⃣ Filter by Status
    @GetMapping("/status/{status}")
    public List<Todo> byStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }

    // 8️⃣ Filter by Priority
    @GetMapping("/priority/{priority}")
    public List<Todo> byPriority(@PathVariable String priority) {
        return service.getByPriority(priority);
    }

    // 9️⃣ Search by Title
    @GetMapping("/search")
    public List<Todo> search(@RequestParam String keyword) {
        return service.search(keyword);
    }
}
