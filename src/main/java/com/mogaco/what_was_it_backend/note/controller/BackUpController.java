package com.mogaco.what_was_it_backend.note.controller;

import com.mogaco.what_was_it_backend.member.service.MemberService;
import com.mogaco.what_was_it_backend.note.controller.dto.BackUpNoteDto;
import com.mogaco.what_was_it_backend.note.controller.dto.BackUpNoteRequest;
import com.mogaco.what_was_it_backend.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BackUpController {

    private final MemberService memberService;
    private final NoteService noteService;

    @PostMapping("/backup")
    public ResponseEntity<Void> backUpNotes(@RequestBody BackUpNoteRequest backUpNoteRequest) {

        memberService.createMember(backUpNoteRequest.getMemberId(), backUpNoteRequest.getPassword());
        noteService.addAllNotes(backUpNoteRequest.getNotes()
                        .stream().map(BackUpNoteDto::toServiceDto)
                        .collect(Collectors.toList()));
        return ResponseEntity.ok().build();
    }

}