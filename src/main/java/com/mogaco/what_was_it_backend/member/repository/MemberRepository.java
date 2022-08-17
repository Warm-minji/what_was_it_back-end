package com.mogaco.what_was_it_backend.member.repository;

import com.mogaco.what_was_it_backend.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByIdAndPassword(String memberId, String password);

    void deleteById(String memberId);
}
