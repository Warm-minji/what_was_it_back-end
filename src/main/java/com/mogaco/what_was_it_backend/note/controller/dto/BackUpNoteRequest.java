package com.mogaco.what_was_it_backend.note.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackUpNoteRequest {

    private String memberId;
    private String password;
    private List<BackUpNoteDto> notes;

}
