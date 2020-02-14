package com.mypjt.portfolio.DTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FreeBoardDTO {
	int bNum; 			//글번호
	String bName;		//글작성자
	String bTitle; 		//글제목
	String bPassword; 	//비밀번호
	String bContent; 	//글내용
	Timestamp bDate; 	//글 생성 날짜
	int bHit; 			//글 조회수
	int bGroup; 		//글 그룹(글의 답글의 그룹)
	int bStep;			//글 스텝(게시글과 답글의 정렬시 사용됩니다.)
	int bIndent;		//들여쓰기(답글앞에 들여쓰기할때 사용됩니다.)
	int bGood;			//추천수
	String bDel;		//삭제 여부
	Timestamp bDelDate;	//삭제 날짜
	String bModi;		//수정 여부
	Timestamp bModifyDate;//수정 날짜
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbPassword() {
		return bPassword;
	}
	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("YY.MM.dd.");
		String date=sdf.format(bDate);
		return date;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	public int getbGood() {
		return bGood;
	}
	public void setbGood(int bGood) {
		this.bGood = bGood;
	}
	
	public FreeBoardDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getbDel() {
		return bDel;
	}
	public void setbDel(String bDel) {
		this.bDel = bDel;
	}
	public String getbDelDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("YY.MM.dd.");
		String date=sdf.format(bDelDate);
		return date;
	}
	public void setbDelDate(Timestamp bDelDate) {
		this.bDelDate = bDelDate;
	}
	
	
	
	public String getbModi() {
		return bModi;
	}
	public void setbModi(String bModi) {
		this.bModi = bModi;
	}
	public String getbModifyDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("YY. MM. dd.");
		String date=sdf.format(bModifyDate);
		return date;
	}
	public void setbModifyDate(Timestamp bModifyDate) {
		this.bModifyDate = bModifyDate;
	}
	
	
	@Override
	public String toString() {
		return "FreeBoardDTO [bNum=" + bNum + ", bName=" + bName + ", bTitle=" + bTitle + ", bPassword=" + bPassword
				+ ", bContent=" + bContent + ", bDate=" + bDate + ", bHit=" + bHit + ", bGroup=" + bGroup + ", bStep="
				+ bStep + ", bIndent=" + bIndent + ", bGood=" + bGood +", bDel=" + bDel +", bDelDate=" + bDelDate +", bModi=" + bModi +", bModifyDate=" + bModifyDate + "]";
	}
	public FreeBoardDTO(int bNum, String bName, String bTitle, String bPassword, String bContent, Timestamp bDate,
			int bHit, int bGroup, int bStep, int bIndent, int bGood,String bDel, Timestamp bDelDate, String bModi, Timestamp bModifyDate) {
		this.bNum = bNum;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bPassword = bPassword;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
		this.bGood = bGood;
		this.bDel=bDel;
		this.bDelDate=bDelDate;
		this.bModi=bModi;
		this.bModifyDate=bModifyDate;
	}
	public FreeBoardDTO(int bNum, String bName, String bTitle, String bPassword, String bContent, int bGroup, int bStep,
			int bIndent) {
		this.bNum = bNum;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bPassword = bPassword;
		this.bContent = bContent;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}
	public FreeBoardDTO(int bNum, String bPassword) {
		super();
		this.bNum = bNum;
		this.bPassword = bPassword;
	}
	
	
	
	
}
