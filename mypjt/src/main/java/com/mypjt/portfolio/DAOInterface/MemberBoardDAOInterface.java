package com.mypjt.portfolio.DAOInterface;

import java.util.List;

import com.mypjt.portfolio.DTO.MemberBoardDTO;

public interface MemberBoardDAOInterface {
	public List<MemberBoardDTO> memberBoardList(int pageNum);
	public void memberBoardWrite(MemberBoardDTO dto);
	public int getMax();
	public MemberBoardDTO memberBoardView(int mbNum);
	public void memberBoardModify(MemberBoardDTO dto);
	public void memberBoardDelete(int mbNum);
}
