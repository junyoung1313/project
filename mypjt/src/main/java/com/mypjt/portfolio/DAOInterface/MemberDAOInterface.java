package com.mypjt.portfolio.DAOInterface;

import com.mypjt.portfolio.DTO.MemberDTO;

public interface MemberDAOInterface {
	void memberInsert(MemberDTO dto);
	MemberDTO memberLogin(MemberDTO dto);
	int memberUpdate(MemberDTO dto);
	int memberDelete(MemberDTO dto);
	int memberIsSelect(MemberDTO dto);
	void memberPWChange(MemberDTO dto);
	int checkId(String mEmail);
	int checkmNickName(String mNickName);
	int checkmPassword(MemberDTO dto);
}
