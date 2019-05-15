package com.albertocamillo.api.controller

import com.albertocamillo.api.data.Todo
import com.albertocamillo.api.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController {

    @Autowired
    private lateinit var service: TodoService

    /**
     * Get todos.
     */
    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getTodos(): Iterable<Todo> = service.getTodos()

    /**
     * Insert item.
     * It consumes JSON, that is: request body Todo.
     */
    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertTodo(
            @RequestBody todo: Todo
    ): Todo = service.insertTodo(todo)

    /**
     * Remove item by Id.
     * We introduced path variable for Id to pass.
     */
    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTodo(
            @PathVariable(name = "id") id: String
    ) = service.deleteTodo(id)

    /**
     * Update item.
     * It consumes JSON, that is: request body Todo.
     * As result it returns boolean. True == success.
     */
    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateTodo(@RequestBody todo: Todo): Todo = service.updateTodo(todo)

}