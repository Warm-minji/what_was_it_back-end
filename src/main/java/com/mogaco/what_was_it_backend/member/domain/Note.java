package com.mogaco.what_was_it_backend.member.domain;

import com.mogaco.what_was_it_backend.member.service.dto.AddNoteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    @CollectionTable(name = "alarm_period", joinColumns = @JoinColumn(name = "note_id"))
    private List<Integer> alarmPeriod;

    private LocalDateTime publishedDate;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isRepeatable;

    public Note(Member member, String title, String category, String keyword, List<Integer> alarmPeriod, LocalDateTime publishedDate, boolean isRepeatable) {
        this.member = member;
        this.title = title;
        this.category = category;
        this.keyword = keyword;
        this.alarmPeriod = alarmPeriod;
        this.publishedDate = publishedDate;
        this.isRepeatable = isRepeatable;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    //===멤버 설정 메서드===//
    public static Note createNote(Member member, AddNoteDto addNoteDto) {
        return new Note(member,
                addNoteDto.getTitle(),
                addNoteDto.getCategory(),
                addNoteDto.getKeyword(),
                addNoteDto.getAlarmPeriod(),
                addNoteDto.getPublishedDate(),
                addNoteDto.isRepeatable());
    }
}
