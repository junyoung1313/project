package com.mypjt.portfolio.DAOInterface;

import java.util.List;

import com.mypjt.portfolio.DTO.FreeBoardDTO;

public interface FreeBoardDAOInterface {

	public List<FreeBoardDTO> freeBoardList(int pageNum);
	public void freeBoardInsert(FreeBoardDTO dto);
	public FreeBoardDTO freeBoardView(int bNum);
	public void freeBoardDelete(int bNum);
	public void freeBoardModify(FreeBoardDTO dto);
	public void freeBoardReply(FreeBoardDTO dto);
	public int getMax();
	public int pwServerCheck(FreeBoardDTO dto);
}

