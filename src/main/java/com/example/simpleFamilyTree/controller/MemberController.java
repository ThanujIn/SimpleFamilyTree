package com.example.simpleFamilyTree.controller;

import com.example.simpleFamilyTree.dto.MemberDTO;
import com.example.simpleFamilyTree.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping(path = "/getMemberById/{memberId}")
    public MemberDTO getMemberById(@PathVariable("memberId") String memberId){
        return memberService.getMemberById(memberId);
    }

    @GetMapping(path = "/findAll")
    public List<MemberDTO> findAll(){
        return memberService.findAll();
    }

    @PostMapping(path = "/addMember")
    public String addMember(@RequestBody MemberDTO member){
        return memberService.addMember(member);
    }

}
