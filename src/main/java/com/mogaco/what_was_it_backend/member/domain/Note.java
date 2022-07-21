package com.mogaco.what_was_it_backend.member.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private String category;
    private String keyword;

    @ElementCollection
    private List<Integer> alarmPeriod;

    public void setMember(Member member) {
        this.member = member;
    }

    private LocalDateTime publishedDate;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isPublished;

//    //====백업 메서드====//
//    public static List<Note> saveNotes(Member member) {
//        Note note = new Note();
//        note.setMember(member);
//
//        List<Note> noteList = new ArrayList<>();
//
//        for (Note notes : noteList) {
//
//        }
//
//
//    }
}
