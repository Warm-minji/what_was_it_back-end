package com.mogaco.what_was_it_backend.member.domain;

import com.mogaco.what_was_it_backend.note.domain.Note;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name = "member_pw")
    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> note = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Member createMember(String memberId, String password) {
        Member member = new Member();
        member.setId(memberId);
        member.setPassword(password);

        return member;
    }
}
