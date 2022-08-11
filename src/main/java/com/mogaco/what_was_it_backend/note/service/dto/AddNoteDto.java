package com.mogaco.what_was_it_backend.note.service.dto;

import com.mogaco.what_was_it_backend.note.domain.RepeatType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class AddNoteDto {

    private String memberId;
    private String title;
    private String category;
    private List<String> keywords;
    private List<LocalDateTime> scheduledDates;
    private RepeatType repeatType;
    private LocalDateTime publishedDate;
}
