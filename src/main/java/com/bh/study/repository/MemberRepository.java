package com.bh.study.repository;

import com.bh.study.domain.Member;

import java.util.List;
import java.util.Optional;

/**
 * 저장소
 */
public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
