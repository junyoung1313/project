package com.mypjt.portfolio.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mypjt.portfolio.DAOInterface.FreeBoardDAOInterface;
import com.mypjt.portfolio.DTO.FreeBoardDTO;
import com.mypjt.portfolio.DataBase.DataBaseManager;

public class FreeBoardDAO implements FreeBoardDAOInterface {
	
	private SqlSessionFactory mapper = DataBaseManager.getInstance(); //SqlMapConfig.xml에 입력되어있는 db관련 정보를 읽어들여 객체로 만들어줍니다.
	
	
	//자유게시판의 list를 db에 요청하여 list로 받아오는 dao메소드 입니다.
	@Override
	public List<FreeBoardDTO> freeBoardList(int pageNum) {
		// TODO Auto-generated method stub
		List<FreeBoardDTO> list = new ArrayList<FreeBoardDTO>();
		SqlSession session = mapper.openSession();

		try {
			list=session.selectList("FreeBoardSQL.FreeBoardList",pageNum);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	//자유게시판에 게시물쓰기 페이지에서 입력받은 데이터를 db에 저장하여 주는 dao메소드입니다.
	@Override
	public void freeBoardInsert(FreeBoardDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();

		try {
			session.insert("FreeBoardSQL.FreeBoardInsert", dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	
	//자유게시판의 게시물을 db에서 조회하여 주는 dao메소드입니다.
	@Override
	public FreeBoardDTO freeBoardView(int bNum) {
		FreeBoardDTO dto=new FreeBoardDTO();
		hitUp(bNum);
		SqlSession session = mapper.openSession();
		try {
			dto=session.selectOne("FreeBoardSQL.FreeBoardView", bNum);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		
		
		return dto;
	}

	//자유게시판의 게시물을 db에서 삭제할때 사용하는 dao메소드입니다.(데이터가 db에서 삭제되진 않으며 조회할수없도록 하였습니다.)
	@Override
	public void freeBoardDelete(int bNum) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();

		try {
			session.update("FreeBoardSQL.FreeBoardDelete", bNum);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	//자유게시판의 게시물의 수정할 데이터를 db에 변경하여주는 dao메소드입니다.
	@Override
	public void freeBoardModify(FreeBoardDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();

		try {
			session.update("FreeBoardSQL.FreeBoardModify", dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	//자유게시판의 게시물의 답글을 db에 추가하여 주는 dao메소드입니다.
	@Override
	public void freeBoardReply(FreeBoardDTO dto) {
		// TODO Auto-generated method stub
		replyShape(dto);
		SqlSession session = mapper.openSession();
		try {
			session.update("FreeBoardSQL.FreeBoardReply", dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//자유게시판에 답글을 추가할때 정렬방식에 있어서 기존에 있던 답글들을 밑으로 내려주기 위해 step을 1씩 증가시켜주는 메소드입니다.
	public void replyShape(FreeBoardDTO dto) {
		SqlSession session = mapper.openSession();

		try {
			session.update("FreeBoardSQL.ReplyShape", dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//자유게시판의 게시물을 조회할때마다 조회수를 증가시켜주는 메소드입니다.
	public void hitUp(int bNum) {
		SqlSession session = mapper.openSession();

		try {
			session.update("FreeBoardSQL.HitUp", bNum);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	//자유게시판의 list를 10개씩 보여줄때 페이지의 갯수를 계산하기위해 게시물의 총 갯수를 count해주는 메소드입니다.
	@Override
	public int getMax() {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		int max=0;
		try {
			max=session.selectOne("FreeBoardSQL.GetMax");
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return max;
	}

	//ajax에서 게시물의 password를 조회사용하는 메소드입니다.
	@Override
	public int pwServerCheck(FreeBoardDTO dto) {
		// TODO Auto-generated method stub
		SqlSession session = mapper.openSession();
		int result=0;
		try {
			result=session.selectOne("FreeBoardSQL.pwServerCheck",dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
