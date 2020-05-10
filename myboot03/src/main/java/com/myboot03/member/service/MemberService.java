package com.myboot03.member.service;

import com.myboot03.member.vo.MemberVO;

import java.util.List;

public interface MemberService {
    public List listMembers() throws Exception;

    public int addMember(MemberVO memberVO) throws Exception;

    public int removeMember(String id) throws Exception;

    public MemberVO login(MemberVO memberVO) throws Exception;
}
