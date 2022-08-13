package com.mogaco.what_was_it_backend.note.controller;

import com.mogaco.what_was_it_backend.member.service.MemberService;
import com.mogaco.what_was_it_backend.note.controller.dto.BackUpNoteDto;
import com.mogaco.what_was_it_backend.note.controller.dto.BackUpNoteRequest;
import com.mogaco.what_was_it_backend.note.controller.dto.DeleteMemberRequest;
import com.mogaco.what_was_it_backend.note.controller.dto.RestoreNotesRequest;
import com.mogaco.what_was_it_backend.note.service.NoteService;
import com.mogaco.what_was_it_backend.note.service.dto.RestoreNoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoteController { //TODO : 비밀번호 제약 추가

    private final MemberService memberService;
    private final NoteService noteService;

    @PostMapping("/backup")
    public ResponseEntity<Void> backUpNotes(@Valid @RequestBody BackUpNoteRequest backUpNoteRequest) {

        memberService.createMember(backUpNoteRequest.getMemberId(), backUpNoteRequest.getPassword());
        noteService.addAllNotes(backUpNoteRequest.getNotes()
                .stream().map(BackUpNoteDto::toServiceDto)
                .collect(Collectors.toList()));

        return ResponseEntity.ok().build();
    }

    @GetMapping("/restore")
    public ResponseEntity<List<RestoreNoteDto>> restoreNotes(@Valid @ModelAttribute RestoreNotesRequest restoreNotesRequest) {

        List<RestoreNoteDto> allNotes = noteService.findAllNotes(restoreNotesRequest.toServiceDto());

        return ResponseEntity.ok(allNotes);
    }

    @DeleteMapping("/delete/member")
    public ResponseEntity<Void> deleteMember(@Valid @RequestBody DeleteMemberRequest deleteMemberRequest) {

        memberService.deleteMember(deleteMemberRequest.getMemberId());

        return ResponseEntity.ok().build();
    }
}
