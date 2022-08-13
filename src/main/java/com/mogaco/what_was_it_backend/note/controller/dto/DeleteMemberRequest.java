package com.mogaco.what_was_it_backend.note.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMemberRequest {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Size(min = 5, max = 12, message = "아이디는 5~12자리까지 가능합니다.")
    private String memberId;
}
