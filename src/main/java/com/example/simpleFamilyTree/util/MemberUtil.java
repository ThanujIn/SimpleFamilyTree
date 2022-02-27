package com.example.simpleFamilyTree.util;

import com.example.simpleFamilyTree.dto.MemberDTO;

public class MemberUtil {
    public static MemberDTO createMember(String id, String name, String age, MemberDTO mother, MemberDTO father, String gender){
        MemberDTO member = new MemberDTO();
        member.setName(name);
        member.setAge(age);
        member.setMother(mother);
        member.setFather(father);
        member.setId(id);
        member.setGender(gender);
        return member;
    }
}
