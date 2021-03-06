package com.example.strater.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.strater.model.Member;
import com.example.strater.service.MemberService;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

	@Autowired
	  private MemberService memberService;

	@GetMapping("/hello")
	public String hello()
	{
		return "Hello Wildan Tamvan!!!";
	}
	  
	  @GetMapping("/members")
	  public List<Member> all() {
	     return memberService.getAllMembers();
	  }

	  @PostMapping("/members")
	  public ResponseEntity<Member> createMember (@Valid @RequestBody Member member) {
	      return ResponseEntity.ok(memberService.saveMember(member));
	  }

	  @PutMapping("/members/{id}")
	  public ResponseEntity<Member> updateMember(@Valid @RequestBody Member member,
	    @PathVariable(value= "id") Long id) {
	        return ResponseEntity.ok(memberService.updateMember(member, id));
	    }

	  @DeleteMapping("/members/{id}")
	  public ResponseEntity<?> deleteMemeber(@PathVariable Long id) {
	    Map<String,String> response = new HashMap<String,String>();
	    if(memberService.deleteMember(id)) {
	      response.put("status", "success");
	      response.put("message", "member deleted successfully");
	       return ResponseEntity.ok(response);
	    } else {
	      response.put("status", "error");
	      response.put("message", "Somthing went wrong when delete the member");
	      return ResponseEntity.status(500).body(response);
	    }
	  }
}
