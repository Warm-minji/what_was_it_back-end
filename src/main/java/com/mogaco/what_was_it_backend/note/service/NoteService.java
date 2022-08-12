package com.mogaco.what_was_it_backend.note.service;

import com.mogaco.what_was_it_backend.member.domain.Member;
import com.mogaco.what_was_it_backend.member.exception.MemberException;
import com.mogaco.what_was_it_backend.member.exception.MemberExceptionType;
import com.mogaco.what_was_it_backend.note.domain.Note;
import com.mogaco.what_was_it_backend.member.repository.MemberRepository;
import com.mogaco.what_was_it_backend.note.repository.NoteRepository;
import com.mogaco.what_was_it_backend.note.service.dto.AddNoteDto;
import com.mogaco.what_was_it_backend.note.service.dto.FindNoteDto;
import com.mogaco.what_was_it_backend.note.service.dto.RestoreNoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoteService {

    private final MemberRepository memberRepository;
    private final NoteRepository noteRepository;

    /**
     * 백업하기
     * TODO : 비밀번호 틀리면 접근 못하게 케이스 추가
     */
    @Transactional
    public void addAllNotes(List<AddNoteDto> addNoteDto) {
        //노트 추가
        for (AddNoteDto noteDto : addNoteDto) {
            //멤버 조회
            Member member = memberRepository.findById(noteDto.getMemberId()).orElseThrow(NoSuchElementException::new);
            //노트 조회
            Note titleNote = noteRepository.findByTitleAndMember(noteDto.getTitle(), member);

            //멤버에 동일한 제목을 가진 노트가 있다면 update해주고, 아니면 새로 노트를 생성
            if (titleNote != null) {
                titleNote.updateNote(noteDto);
                continue;
            }
            Note note = Note.createNote(member, noteDto);
            noteRepository.save(note);
        }
    }

    /**
     * 복원하기
     */
    public List<RestoreNoteDto> findAllNotes(FindNoteDto findNoteDto) {

        Member member = memberRepository
                .findById(findNoteDto.getMemberId())
                .orElseThrow(() -> new MemberException(MemberExceptionType.WRONG_ID));

        return noteRepository.findAllByMember(member)
                .stream().map(note -> new RestoreNoteDto(note.getMember().getId(),
                        note.getTitle(),
                        note.getCategory(),
                        note.getKeywords(),
                        note.getScheduledDates(),
                        note.getRepeatType(),
                        note.getPublishedDate()))
                .collect(Collectors.toList());
    }

//    /**
//     * 모든 노트 삭제
//     */
//    @Transactional
//    public void deleteAllNotes(String memberId) {
//
//        Member member = memberRepository
//                .findById(memberId)
//                .orElseThrow(() -> new MemberException(MemberExceptionType.WRONG_ID));
//        noteRepository.removeAllByMember(member);
//    }


}
