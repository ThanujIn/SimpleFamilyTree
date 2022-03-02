package com.example.simpleFamilyTree.service;

import com.example.simpleFamilyTree.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ChildrenService {

    public List<MemberDTO> getDecendentsByMember(String memberId){
        MemberService memberService = new MemberService();
        List<MemberDTO> memberDTOs = memberService.getMembers();
        MemberDTO matchingMember = new MemberDTO();
        boolean found = false;

        for(MemberDTO member : memberDTOs){
            if(member.getId().equals(memberId)){
                matchingMember = member;
                found = true;
            }
        }
        if(!found){
            return null;
        }else{
            if(matchingMember.getChildren() != null){
                return matchingMember.getChildren();
            }else{
                return null;
            }
        }
    }

    public List<MemberDTO> getAncestorByMember(String memberId){
        MemberService memberService = new MemberService();
        List<MemberDTO> memberDTOs = memberService.getMembers();
        List<MemberDTO> decendentsDTOs = new ArrayList<>();
        MemberDTO matchingMember = new MemberDTO();
        boolean found = false;

        for(MemberDTO member : memberDTOs){
            if(member.getId().equals(memberId)){
                matchingMember = member;
                found = true;
            }
        }
        Map<String, MemberDTO> memberDTOMap = memberService.loadMembersToMap();
        if(memberDTOMap.get(matchingMember.getMother().getId()) == null && memberDTOMap.get(matchingMember.getFather().getId()) == null){
            return null;
        }else {
            decendentsDTOs.add(memberDTOMap.get(matchingMember.getMother().getId()));
            decendentsDTOs.add(memberDTOMap.get(matchingMember.getFather().getId()));
            return decendentsDTOs;
        }
    }

}
