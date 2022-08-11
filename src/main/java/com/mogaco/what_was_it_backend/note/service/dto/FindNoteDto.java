package com.mogaco.what_was_it_backend.note.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindNoteDto {

    private String memberId;
    private String password;
}
