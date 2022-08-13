package com.mogaco.what_was_it_backend.note.controller.dto;

import com.mogaco.what_was_it_backend.note.service.dto.FindNoteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestoreNotesRequest {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Size(min = 5, max = 12, message = "아이디는 5~12자리로 입력해야 합니다.")
    private String memberId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 6, max = 20, message = "비밀번호는 6~20자리로 입력해야 합니다.")
    private String password;

    public FindNoteDto toServiceDto() {
        return new FindNoteDto(memberId, password);
    }
}
