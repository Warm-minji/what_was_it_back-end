package com.mogaco.what_was_it_backend.member.repository;

import com.mogaco.what_was_it_backend.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, String> {

    void deleteById(String memberId);
}
