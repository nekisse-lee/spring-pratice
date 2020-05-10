package com.myboot03.member.service;


import com.myboot03.member.dao.MemberDAO;
import com.myboot03.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
    @Qualifier("memberDAO")
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public List listMembers() throws Exception {
        List membersList = null;
        membersList = memberDAO.selectAllMemberList();
        return membersList;
    }

    @Override
    public int addMember(MemberVO member) throws Exception {
        return memberDAO.insertMember(member);
    }

    @Override
    public int removeMember(String id) throws Exception {
        return memberDAO.deleteMember(id);
    }

    public MemberVO login(MemberVO memberVO) throws Exception {
        return memberDAO.loginById(memberVO);
    }
}
