package com.albertocamillo.api.repository

import com.albertocamillo.api.data.Todo
import org.springframework.data.repository.CrudRepository

/**
 * String is the type for ID we use.
 */
interface TodoRepository : CrudRepository<Todo, String>