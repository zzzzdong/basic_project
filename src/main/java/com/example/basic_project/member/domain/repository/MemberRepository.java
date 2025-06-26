package com.example.basic_project.member.domain.repository;

import com.example.basic_project.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
