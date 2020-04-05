package com.example.strater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.strater.model.Member;
import com.example.strater.repository.MemberRepository;

@Service("memberService")
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public Member findMemberByEmail(String email) {
	       return memberRepository.findByEmail(email);
	   }

	   public List<Member> getAllMembers() {
	       return memberRepository.findAll();
	   }

	   public Member saveMember(Member member) {
	       return memberRepository.save(member);
	   }

	   public Member updateMember(Member member, Long id) {
	     Member updateMember = memberRepository.findById(id).orElse(null);
	     if(updateMember != null) {
	         updateMember.setFirstName(member.getFirstName());
	         updateMember.setLastName(member.getLastName());
	         updateMember.setEmail(member.getEmail());
	     }
	     final Member mymember = memberRepository.save(updateMember);
	     return mymember;
	   }

	   public Boolean deleteMember (Long id) {
	      Member delMember  = memberRepository.findById(id).orElse(null);
	      if(delMember != null) {
	          memberRepository.delete(delMember);
	          return true;
	      }
	      return false;
	   }
}
