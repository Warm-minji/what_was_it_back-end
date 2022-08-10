package com.mogaco.what_was_it_backend.member.controller.dto;

import com.mogaco.what_was_it_backend.member.service.dto.AddNoteDto;
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
    private String keyword;
    private List<Integer> alarmPeriod;
    private LocalDateTime publishedDate;
    private boolean isRepeatable;

    public AddNoteDto toServiceDto() {
        return new AddNoteDto(memberId, title, category, keyword, alarmPeriod, publishedDate, isRepeatable);
    }
}
