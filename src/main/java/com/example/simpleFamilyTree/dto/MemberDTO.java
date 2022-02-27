package com.example.simpleFamilyTree.dto;

import java.util.List;

public class MemberDTO {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public MemberDTO getMother() {
        return mother;
    }

    public void setMother(MemberDTO mother) {
        this.mother = mother;
    }

    public MemberDTO getFather() {
        return father;
    }

    public void setFather(MemberDTO father) {
        this.father = father;
    }

    public List<MemberDTO> getChildren() {
        return children;
    }

    public void setChildren(List<MemberDTO> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;
    private String age;
    private MemberDTO mother;
    private MemberDTO father;
    private List<MemberDTO> children;
    private String id;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;
}
