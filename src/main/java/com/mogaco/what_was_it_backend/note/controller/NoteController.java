package com.mogaco.what_was_it_backend.note.controller;

import com.mogaco.what_was_it_backend.member.service.MemberService;
import com.mogaco.what_was_it_backend.note.controller.dto.BackUpNoteDto;
import com.mogaco.what_was_it_backend.note.controller.dto.BackUpNoteRequest;
import com.mogaco.what_was_it_backend.note.controller.dto.DeleteMemberAndNotesRequest;
import com.mogaco.what_was_it_backend.note.controller.dto.RestoreNotesRequest;
import com.mogaco.what_was_it_backend.note.service.NoteService;
import com.mogaco.what_was_it_backend.note.service.dto.RestoreNoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoteController {

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

    @GetMapping("/restore")
    public ResponseEntity<List<RestoreNoteDto>> restoreNotes(@ModelAttribute RestoreNotesRequest restoreNotesRequest) {

        List<RestoreNoteDto> allNotes = noteService.findAllNotes(restoreNotesRequest.toServiceDto());

        return ResponseEntity.ok(allNotes);
    }

    /**
     * TODO : 한 트랜잭션 안에서 해결하기
     * @param deleteMemberAndNotesRequest
     * @return
     */
    @DeleteMapping("/delete/notes")
    public ResponseEntity<Void> deleteMemberAndNotes(@RequestBody DeleteMemberAndNotesRequest deleteMemberAndNotesRequest) {

        noteService.deleteAllNotes(deleteMemberAndNotesRequest.getMemberId());
        memberService.deleteMember(deleteMemberAndNotesRequest.getMemberId());

        return ResponseEntity.ok().build();
    }
}
