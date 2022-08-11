package com.mogaco.what_was_it_backend.note.domain;

import com.mogaco.what_was_it_backend.member.domain.Member;
import com.mogaco.what_was_it_backend.note.service.dto.AddNoteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @ElementCollection
    @CollectionTable(name = "keywords", joinColumns = @JoinColumn(name = "note_id"))
    private List<String> keywords;

    @ElementCollection
    @CollectionTable(name = "scheduled_dates", joinColumns = @JoinColumn(name = "note_id"))
    private List<LocalDateTime> scheduledDates;

    private RepeatType repeatType;

    private LocalDateTime publishedDate;

    public Note(Member member, String title, String category, List<String> keywords, List<LocalDateTime> scheduledDates, RepeatType repeatType, LocalDateTime publishedDate) {
        this.member = member;
        this.title = title;
        this.category = category;
        this.keywords = keywords;
        this.scheduledDates = scheduledDates;
        this.repeatType = repeatType;
        this.publishedDate = publishedDate;
    }

    //===생성 메서드===//
    public static Note createNote(Member member, AddNoteDto addNoteDto) {
        return new Note(member,
                addNoteDto.getTitle(),
                addNoteDto.getCategory(),
                addNoteDto.getKeywords(),
                addNoteDto.getScheduledDates(),
                addNoteDto.getRepeatType(),
                addNoteDto.getPublishedDate());
    }

    //===업데이트 로직===//
    public void updateNote(AddNoteDto note) {
        this.title = note.getTitle();
        this.category = note.getCategory();
        this.keywords = note.getKeywords();
        this.scheduledDates = note.getScheduledDates();
        this.repeatType = note.getRepeatType();
        this.publishedDate = note.getPublishedDate();
    }
}
