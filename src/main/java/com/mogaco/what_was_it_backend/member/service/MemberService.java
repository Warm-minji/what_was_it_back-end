package com.mogaco.what_was_it_backend.member.service;

import com.mogaco.what_was_it_backend.member.domain.Member;
import com.mogaco.what_was_it_backend.member.exception.MemberException;
import com.mogaco.what_was_it_backend.member.exception.MemberExceptionType;
import com.mogaco.what_was_it_backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(String memberId, String password) {

        //이미 존재하는 Id면 exception throw
        if (memberRepository.findById(memberId).isPresent()) {
            throw new MemberException(MemberExceptionType.ALREADY_EXIST_USER);
        }
        //Id가 존재하지 않으면 생성
        Member member = Member.createMember(memberId, password);
        memberRepository.save(member);
    }

    @Transactional
    public void deleteMember(String memberId) {
        memberRepository.removeById(memberId);
    }
}
