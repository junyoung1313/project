package com.mypjt.portfolio.DTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MemberBoardDTO {
	private int mbNum;			//글번호
	private String mEmail;		//작성자(회원 email 닉네임 변경 후에 자신의 글인지 판단하는 용도입니다.)
	private String mNickName;	//작성자 닉네임(닉네임 변경 후에 따로 변경되어지지 않습니다.)
	private String mbTitle;		//글제목
	private String mbContent;	//글내용
	private Timestamp mbDate;	//생성 날짜
	private int mbHit;			//조회수
	private int mbGoods;		//추천수
	private String mbIsModify;	//수정 여부
	private Timestamp mbModify;	//수정 날짜
	private String mbIsDelete;	//삭제 여부
	private Timestamp mbDelete;	//삭제 날짜
	public int getMbNum() {
		return mbNum;
	}
	public void setMbNum(int mbNum) {
		this.mbNum = mbNum;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmNickName() {
		return mNickName;
	}
	public void setmNickName(String mNickName) {
		this.mNickName = mNickName;
	}
	public String getMbTitle() {
		return mbTitle;
	}
	public void setMbTitle(String mbTitle) {
		this.mbTitle = mbTitle;
	}
	public String getMbContent() {
		return mbContent;
	}
	public void setMbContent(String mbContent) {
		this.mbContent = mbContent;
	}
	public String getMbDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("YY.MM.dd.");
		String date=sdf.format(mbDate);
		return date;
	}
	public void setMbDate(Timestamp mbDate) {
		this.mbDate = mbDate;
	}
	public int getMbHit() {
		return mbHit;
	}
	public void setMbHit(int mbHit) {
		this.mbHit = mbHit;
	}
	public int getMbGoods() {
		return mbGoods;
	}
	public void setMbGoods(int mbGoods) {
		this.mbGoods = mbGoods;
	}
	public String getMbIsModify() {
		return mbIsModify;
	}
	public void setMbIsModify(String mbIsModify) {
		this.mbIsModify = mbIsModify;
	}
	public Timestamp getMbModify() {
		return mbModify;
	}
	public void setMbModify(Timestamp mbModify) {
		this.mbModify = mbModify;
	}
	public String getMbIsDelete() {
		return mbIsDelete;
	}
	public void setMbIsDelete(String mbIsDelete) {
		this.mbIsDelete = mbIsDelete;
	}
	public Timestamp getMbDelete() {
		return mbDelete;
	}
	public void setMbDelete(Timestamp mbDelete) {
		this.mbDelete = mbDelete;
	}
	@Override
	public String toString() {
		return "MemberBoardDTO [mbNum=" + mbNum + ", mEmail=" + mEmail + ", mNickName=" + mNickName + ", mbTitle="
				+ mbTitle + ", mbContent=" + mbContent + ", mbDate=" + mbDate + ", mbHit=" + mbHit + ", mbGoods="
				+ mbGoods + ", mbIsModify=" + mbIsModify + ", mbModify=" + mbModify + ", mbIsDelete=" + mbIsDelete
				+ ", mbDelete=" + mbDelete + "]";
	}
	public MemberBoardDTO(String mEmail, String mNickName, String mbTitle, String mbContent) {
		this.mEmail = mEmail;
		this.mNickName = mNickName;
		this.mbTitle = mbTitle;
		this.mbContent = mbContent;
	}
	
	public MemberBoardDTO(int mbNum, String mbTitle, String mbContent) {
		super();
		this.mbNum = mbNum;
		this.mbTitle = mbTitle;
		this.mbContent = mbContent;
	}
	public MemberBoardDTO() {
	}
	
	
}
