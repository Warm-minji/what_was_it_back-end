package com.mogaco.what_was_it_backend.member.service;

import com.mogaco.what_was_it_backend.global.exception.BaseExceptionType;
import com.mogaco.what_was_it_backend.member.domain.Member;
import com.mogaco.what_was_it_backend.member.exception.MemberException;
import com.mogaco.what_was_it_backend.member.exception.MemberExceptionType;
import com.mogaco.what_was_it_backend.note.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(String memberId, String password) {
        //Id가 존재하지 않으면 생성
        if (memberRepository.findById(memberId).isEmpty()) {
            Member member = Member.createMember(memberId, password);
            memberRepository.save(member);
        } else {
            //이미 존재하는 Id면 exception throw
            throw new MemberException(MemberExceptionType.ALREADY_EXIST_USER);
        }
    }
}
