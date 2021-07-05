package com.bh.study.service;

import com.bh.study.domain.Member;
import com.bh.study.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repository;

    // Dependency Injection (DI)
    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId);
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        // given
        Member mem1 = new Member();
        mem1.setName("hello");

        Member mem2 = new Member();
        mem2.setName("hello");

        // when
        memberService.join(mem1);
        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(mem2));

//        try {
//            memberService.join(mem2);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        // then
    }
}