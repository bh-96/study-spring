package com.bh.study.repository;

import com.bh.study.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 테스트 간 의존도가 생기면 안된다!
 * TDD : 테스트를 먼저 해보고 개발한다. (테스트 주도형 개발)
 */
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // Assertions
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member mem1 = new Member();
        mem1.setName("spring1");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setName("spring2");
        repository.save(mem2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(mem1);
    }

    @Test
    void findAll() {
        Member mem1 = new Member();
        mem1.setName("spring1");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setName("spring2");
        repository.save(mem2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}