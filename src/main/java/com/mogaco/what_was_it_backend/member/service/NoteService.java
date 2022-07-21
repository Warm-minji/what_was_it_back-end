package com.mogaco.what_was_it_backend.member.service;

import com.mogaco.what_was_it_backend.member.domain.Member;
import com.mogaco.what_was_it_backend.member.domain.Note;
import com.mogaco.what_was_it_backend.member.repository.MemberRepository;
import com.mogaco.what_was_it_backend.member.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void backUpNotes(String memberId, List<Note> notes) {
        //멤버 조회
        Member member = memberRepository.findById(memberId).orElseThrow(null);
        //멤버의 노트 조회
        List<Note> noteList = noteRepository.findAllByMember(member);

        for (Note note : noteList) {

        }

    }
}
