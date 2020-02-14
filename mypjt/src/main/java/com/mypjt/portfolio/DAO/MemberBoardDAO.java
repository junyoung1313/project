package com.mypjt.portfolio.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mypjt.portfolio.DAOInterface.MemberBoardDAOInterface;
import com.mypjt.portfolio.DTO.MemberBoardDTO;
import com.mypjt.portfolio.DataBase.DataBaseManager;

public class MemberBoardDAO implements MemberBoardDAOInterface {
	
	private SqlSessionFactory mapper = DataBaseManager.getInstance();//SqlMapConfig.xml에 입력되어있는 db관련 정보를 읽어들여 객체로 만들어줍니다.

	//회원게시판의 게시물의 list를 db에서 조회하여주는 dao메소드입니다.
	@Override
	public List<MemberBoardDTO> memberBoardList(int pageNum) {
		// TODO Auto-generated method stub
				List<MemberBoardDTO> list = new ArrayList<MemberBoardDTO>();
				SqlSession session = mapper.openSession();

				try {
					list=session.selectList("MemberBoardSQL.MemberBoardList",pageNum);
					session.commit();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					session.close();
				}
				return list;
	}

	//회원게시판의 게시물을 db에 새로 저장할때 사용하는 dao메소드입니다.
	@Override
	public void memberBoardWrite(MemberBoardDTO dto) {
		SqlSession session = mapper.openSession();

		try {
			session.insert("MemberBoardSQL.MemberBoardWrite",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	//회원게시판의 list를 10개씩 보여줄때 페이지의 갯수를 계산하기위해 게시물의 총 갯수를 count해주는 메소드입니다.
	@Override
	public int getMax() {
		SqlSession session = mapper.openSession();
		int result=0;
		try {
			result=session.selectOne("MemberBoardSQL.GetMax");
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	//회원게시판의 게시물을 db에서 조회하여주는 dao메소드입니다.
	@Override
	public MemberBoardDTO memberBoardView(int mbNum) {
		SqlSession session = mapper.openSession();
		MemberBoardDTO dto=new MemberBoardDTO();
		try {
			dto=session.selectOne("MemberBoardSQL.MemberBoardView",mbNum);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}

	//회원게시판의 게시물을 수정할때 사용되는 dao메소드입니다.
	@Override
	public void memberBoardModify(MemberBoardDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		try {
			session.update("MemberBoardSQL.MemberBoardModify",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	//회원게시판의 게시물을 삭제할때 사용하는 dao메소드입니다.(실제로 삭제되진않으며 IsDelete의 값을 조회할수없도록 'Y'로 변경하여줍니다.
	@Override
	public void memberBoardDelete(int mbNum) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		try {
			session.update("MemberBoardSQL.MemberBoardDelete",mbNum);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
