package com.albertocamillo.api.repository

import com.albertocamillo.api.data.Note
import org.springframework.data.repository.CrudRepository

/**
 * String is the type for ID we use.
 */
interface NoteRepository : CrudRepository<Note, String>