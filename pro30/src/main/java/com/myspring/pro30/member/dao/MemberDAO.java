package com.myspring.pro30.member.dao;

import com.myspring.pro30.member.vo.MemberVO;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MemberDAO {
    public List selectAllMemberList() throws DataAccessException;

    public int insertMember(MemberVO memberVO) throws DataAccessException;

    public int deleteMember(String id) throws DataAccessException;

    public MemberVO loginById(MemberVO memberVO) throws DataAccessException;

}
