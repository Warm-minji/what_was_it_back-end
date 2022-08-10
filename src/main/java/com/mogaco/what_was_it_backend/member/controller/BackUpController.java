package com.mogaco.what_was_it_backend.member.controller;

import com.mogaco.what_was_it_backend.member.controller.dto.BackUpNoteDto;
import com.mogaco.what_was_it_backend.member.controller.dto.BackUpNoteRequest;
import com.mogaco.what_was_it_backend.member.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BackUpController {

    private final NoteService noteService;

    @PostMapping("/backup")
    public ResponseEntity<Void> backUpNotes(@RequestBody BackUpNoteRequest backUpNoteRequest) {

        noteService.addNotes(backUpNoteRequest.getNotes()
                        .stream().map(BackUpNoteDto::toServiceDto)
                        .collect(Collectors.toList()));
        return ResponseEntity.ok().build();
    }
}
