package com.mogaco.what_was_it_backend.member.controller;

import com.mogaco.what_was_it_backend.member.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BackUpController {

    private final NoteService noteService;


}
