package com.mogaco.what_was_it_backend.member.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class AddNoteDto {

    private Long memberId;
    private String title;
    private String category;
    private String keyword;
    private List<Integer> alarmPeriod;
    private LocalDateTime publishedDate;
    private boolean isRepeatable;
}
