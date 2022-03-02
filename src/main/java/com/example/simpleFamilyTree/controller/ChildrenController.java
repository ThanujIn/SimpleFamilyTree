package com.example.simpleFamilyTree.controller;

import com.example.simpleFamilyTree.dto.MemberDTO;
import com.example.simpleFamilyTree.service.ChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/children")
public class ChildrenController {

    @Autowired
    ChildrenService childrenService;

    @GetMapping(path = "/getDecendentsByMember/{memberName}")
    public ResponseEntity<List<MemberDTO>> getDecendentsByMember(@PathVariable("memberName") String memberId){
        List<MemberDTO> parents = childrenService.getDecendentsByMember(memberId);
        return ResponseEntity.badRequest().body(parents == null ? new ArrayList<>() : parents);
    }

    @GetMapping(path = "/getAncestorByMember/{memberName}")
    public ResponseEntity<List<MemberDTO>> getAncestorByMember(@PathVariable("memberName") String memberId){
        List<MemberDTO> decendents = childrenService.getAncestorByMember(memberId);
        return ResponseEntity.badRequest().body(decendents == null ? new ArrayList<>() : decendents);
    }
}
