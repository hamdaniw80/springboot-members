package com.example.strater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.strater.model.Member;

@Repository("memberRepository")
public interface MemberRepository extends JpaRepository<Member, Long> {

	Member findByEmail(String email);
}
