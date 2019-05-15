package com.albertocamillo.api.controller

import com.albertocamillo.api.data.Note
import com.albertocamillo.api.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController {

    @Autowired
    private lateinit var service: NoteService

    /**
     * Get notes.
     */
    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNotes() = service.getNotes()

    /**
     * Insert note.
     * It consumes JSON, that is: request body Note.
     */
    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertNote(
            @RequestBody note: Note
    ) = service.insertNote(note)

    /**
     * Remove note by Id.
     * We introduced path variable for Id to pass.
     */
    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNote(
            @PathVariable(name = "id") id: String
    ) = service.deleteNote(id)

/**
 * Update item.
 * It consumes JSON, that is: request body Note.
 * As result it returns boolean, True == success.
 */
@PostMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
)
fun updateNote(
        @RequestBody note: Note
): Note = service.updateNote(note)

}