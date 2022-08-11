package com.mogaco.what_was_it_backend.note.repository;

import com.mogaco.what_was_it_backend.member.domain.Member;
import com.mogaco.what_was_it_backend.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Note findByTitleAndMember(String title, Member member);

    List<Note> findAllByMember(Member member);

    void removeAllByMember(Member member);
}
