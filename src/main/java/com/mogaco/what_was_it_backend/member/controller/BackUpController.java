package com.mogaco.what_was_it_backend.member.controller;

import com.mogaco.what_was_it_backend.member.controller.dto.BackUpNoteRequest;
import com.mogaco.what_was_it_backend.member.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BackUpController {

    private final NoteService noteService;

    @PostMapping("/backup")
    public ResponseEntity<Void> backUpNotes(@RequestBody BackUpNoteRequest backUpNoteRequest) {

//        noteService.addNotes(backUpNoteRequest.getMemberId(), backUpNoteRequest.toServiceDto());
        return ResponseEntity.ok().build();
    }
}
