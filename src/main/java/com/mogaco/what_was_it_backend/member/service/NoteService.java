package com.mogaco.what_was_it_backend.member.service;

import com.mogaco.what_was_it_backend.member.domain.Member;
import com.mogaco.what_was_it_backend.member.domain.Note;
import com.mogaco.what_was_it_backend.member.repository.MemberRepository;
import com.mogaco.what_was_it_backend.member.repository.NoteRepository;
import com.mogaco.what_was_it_backend.member.service.dto.AddNoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoteService {

    private final MemberRepository memberRepository;
    private final NoteRepository noteRepository;

    /**
     * 백업하기
     */
    @Transactional
    public void addNotes(String memberId, List<Note> notes, AddNoteDto addNoteDto) {
        //멤버 조회
        Member member = memberRepository.findById(memberId).orElseThrow(NoSuchElementException::new);
        //노트 생성
        for (Note note : notes) {
            Note createdNote = Note.createNote(member, addNoteDto);
            noteRepository.save(createdNote);
        }
    }

    /**
     * 복원하기
     */

}
