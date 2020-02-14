package com.mypjt.portfolio.DTO;

import java.sql.Timestamp;

public class MemberDTO {
	private String mEmail;			//회원 email
	private String mPassword;		//비밀번호
	private String mNickName;		//닉네임
	private Timestamp mJoinDate;	//가입 날짜
	private String mIsDelete;		//탈퇴 여부
	private Timestamp mDeleteDate;	//탈퇴 날짜
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getmNickName() {
		return mNickName;
	}
	public void setmNickName(String mNickName) {
		this.mNickName = mNickName;
	}
	public Timestamp getmJoinDate() {
		return mJoinDate;
	}
	public void setmJoinDate(Timestamp mJoinDate) {
		this.mJoinDate = mJoinDate;
	}
	public String getmIsDelete() {
		return mIsDelete;
	}
	public void setmIsDelete(String mIsDelete) {
		this.mIsDelete = mIsDelete;
	}
	public Timestamp getmDeleteDate() {
		return mDeleteDate;
	}
	public void setmDeleteDate(Timestamp mDeleteDate) {
		this.mDeleteDate = mDeleteDate;
	}
	@Override
	public String toString() {
		return "MemberDTO [mEmail=" + mEmail + ", mPassword=" + mPassword + ", mNickName="
				+ mNickName + ", mJoinDate=" + mJoinDate + ", mIsDelete=" + mIsDelete + ", mDeleteDate=" + mDeleteDate
				+ "]";
	}
	public MemberDTO(String mEmail, String mPassword, String mNickName) {
		this.mEmail = mEmail;
		this.mPassword = mPassword;
		this.mNickName = mNickName;
	}
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String mEmail, String mPassword) {
		// TODO Auto-generated constructor stub
		this.mEmail = mEmail;
		this.mPassword = mPassword;
	}
	
}
