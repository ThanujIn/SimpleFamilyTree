package com.example.simpleFamilyTree.service;

import com.example.simpleFamilyTree.dto.MemberDTO;
import com.example.simpleFamilyTree.util.MemberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private static MemberUtil memberUtil;

    private static List<MemberDTO> loadMembersFromDb(){
        List<MemberDTO> membersList = new ArrayList<>();
        MemberDTO initialMother = MemberUtil.createMember("1", "Ada", "83",null, null, "Female");
        MemberDTO initialFather = MemberUtil.createMember("2", "Albert", "86",null, null,  "Male");
        membersList.add(initialMother);
        membersList.add(initialFather);
        return membersList;
    }

    private List<MemberDTO> members = loadMembersFromDb();


    public MemberDTO getMemberById(String memberId){
        MemberDTO memberDTO = new MemberDTO();
        boolean found = false;
        for(MemberDTO member : members){
            if(member.getId().equals(memberId)){
                memberDTO = member;
                found = true;
            }
        }
        return found ? memberDTO : null;
    }

    public List<MemberDTO> findAll(){
        return members;
    }
}
