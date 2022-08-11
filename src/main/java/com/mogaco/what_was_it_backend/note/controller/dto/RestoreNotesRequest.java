package com.mogaco.what_was_it_backend.note.controller.dto;

import com.mogaco.what_was_it_backend.note.service.dto.FindNoteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestoreNotesRequest {

    private String memberId;
    private String password;

    public FindNoteDto toServiceDto() {
        return new FindNoteDto(memberId, password);
    }
}
