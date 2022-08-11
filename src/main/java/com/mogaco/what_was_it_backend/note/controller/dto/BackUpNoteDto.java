package com.mogaco.what_was_it_backend.note.controller.dto;

import com.mogaco.what_was_it_backend.note.domain.RepeatType;
import com.mogaco.what_was_it_backend.note.service.dto.AddNoteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackUpNoteDto {

    private String memberId;
    private String title;
    private String category;
    private List<String> keywords;
    private List<LocalDateTime> scheduledDates;
    private RepeatType repeatType;
    private LocalDateTime publishedDate;

    public AddNoteDto toServiceDto() {
        return new AddNoteDto(memberId, title, category, keywords, scheduledDates, repeatType, publishedDate);
    }
}
