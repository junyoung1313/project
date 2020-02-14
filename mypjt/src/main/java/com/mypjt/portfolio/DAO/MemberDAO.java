package com.mypjt.portfolio.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mypjt.portfolio.DAOInterface.MemberDAOInterface;
import com.mypjt.portfolio.DTO.MemberDTO;
import com.mypjt.portfolio.DataBase.DataBaseManager;

public class MemberDAO implements MemberDAOInterface {

	private SqlSessionFactory mapper = DataBaseManager.getInstance();//SqlMapConfig.xml에 입력되어있는 db관련 정보를 읽어들여 객체로 만들어줍니다.
	
	//회원가입시에 회원정보를 db에 저장하여 주는 dao메소드입니다.
	@Override
	public void memberInsert(MemberDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();

		try {
			session.insert("MemberSQL.MemberInsert",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	//login할때 입력한 email과 password를 db에서 조회하여 주는 dao메소드입니다.
	@Override
	public MemberDTO memberLogin(MemberDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		MemberDTO isLogin=new MemberDTO();
		try {
			isLogin=session.selectOne("MemberSQL.MemberLogin",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isLogin; 
	}


	//회원정보 중 닉네임을 변경하는 dao메소드입니다.
	@Override
	public int memberUpdate(MemberDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		int result=0;
		try {
			result=session.update("MemberSQL.MemberUpdate",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	//회원탈퇴시에 사용되는 dao메소드입니다.(db에서 데이터가 삭제되진 않으며 isDelete의 값을 'Y'로 변경하여 로그인 할수없도록 처리합니다.)
	@Override
	public int memberDelete(MemberDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		int result=0;
		try {
			result=session.update("MemberSQL.MemberDelete",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	//회원의 탈퇴여부를 조회하는 dao메소드입니다.
	@Override
	public int memberIsSelect(MemberDTO dto) {
		SqlSession session = mapper.openSession();
		int result=0;
		try {
			result=session.selectOne("MemberSQL.MemberIsSelect",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	//회원의 비밀번호를 변경할때 사용하는 dao메소드입니다.
	@Override
	public void memberPWChange(MemberDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		try {
			session.selectOne("MemberSQL.MemberPWChange",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	//회원의 email의 중복확인을 할때 사용하는 메소드입니다.(회원가입시 email을 변경할때 ajax로 서버에 접근하여 중복확인을 할수있도록 조회하는 용도입니다.) 
	@Override
	public int checkId(String mEmail) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		int result=0;
		try {
			result=session.selectOne("MemberSQL.checkEmail",mEmail);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	//회원가입 또는 닉네임 변경시에 ajax로 서버에 접근하여 중복확인을 할때 사용하는 메소드입니다.
	@Override
	public int checkmNickName(String mNickName) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		int result=0;
		try {
			result=session.selectOne("MemberSQL.checkNickname",mNickName);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	//로그인,회원정보 수정시에 입력한 비밀번호가 db의 비밀번호와 동일한지 ajax로 서버에 접근하여 확인하는 메소드입니다.
	@Override
	public int checkmPassword(MemberDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		int result=0;
		try {
			result=session.selectOne("MemberSQL.checkPassword",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
