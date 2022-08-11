package com.mogaco.what_was_it_backend.note.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMemberAndNotesRequest {

    private String memberId;
}
