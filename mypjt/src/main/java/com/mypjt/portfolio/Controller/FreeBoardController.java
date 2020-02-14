package com.mypjt.portfolio.Controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mypjt.portfolio.DAOInterface.FreeBoardDAOInterface;
import com.mypjt.portfolio.DTO.FreeBoardDTO;

@Controller
@RequestMapping("/freeBoard")         //web.xml에서 servlet mapping을 이용하여 controller에 접근할때 url앞부분(자유게시판을 이용할경우 고정적인 url부분입니다.)
public class FreeBoardController {
	FreeBoardDAOInterface dao;    //다형성을 이용하여 dao의 수정 및 교체를 용이하게 하기위하여 interface로 선언.
	
	public void setDao(FreeBoardDAOInterface dao) { //controller에서 db에 접근하여 처리할 dao를 주입시켜주는 setter입니다.(DAO-servlet-context.xml에서  주입하여 줍니다.)
		this.dao = dao;
	}
	
	//자유게시판의 list를 db를 받아와 출력할 view page를 설정해주는controller입니다.
	@RequestMapping("/freeBoardList") 
	public ModelAndView freeBoardList(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		System.out.println("freeBoardList()");
		int pageNum=1; //기본적으로 게시물의  1page를 보여주기 위하여 기본값을 1로 설정해주었습니다.
		String stringPageNum=request.getParameter("pageNum");
		if(!(stringPageNum==null||stringPageNum=="1"))pageNum=Integer.parseInt(stringPageNum);
		
		//게시물의 총 갯수를 불러오는  dao함수를 호출합니다.
		int max=dao.getMax();
		
		//게시물의 총 갯수를 사용하여 listpage의 마지막 page번호를 구합니다.
		if(max%10>0) {max=max/10+1;}
		else {max=max/10;}
		
		int endPage=max;
		int startPage=1;
		
		//게시물의 listpage를 현재 pageNum을 기준으로 앞쪽 5페이지,뒷쪽 4페이지를 설정하는 구문입니다. 
		if(max>10) {
			if(pageNum>max-4)startPage=max-9;
			else if(pageNum>=7)startPage=pageNum-5;
			if(pageNum<7)endPage=10;
			else if(pageNum+4<max)endPage=pageNum+4;
		}
		
		//view page구현시 사용하는 데이터 및 viewpage(.jsp)를 ModelAndView객체에 추가하여줍니다.
		mav.addObject("max", max);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("pageNum",pageNum);
		mav.addObject("dtos", dao.freeBoardList(pageNum));
		mav.setViewName("freeBoard/freeBoardList");
		return mav;
	}
	
	
	//게시판의 글쓰기 페이지를 출력할수있게 ModelAndView객체에 페이지를 설정해주는 controller입니다.
	@RequestMapping("/freeBoardWriteView")
	public ModelAndView freeBoardWriteView() {
		System.out.println("freeBoardWriteView()");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("freeBoard/freeBoardWriteView");
		return mav;
	}
	
	
	//게시판의 글쓰기 페이지에서 작성된 게시물의 데이터를 받아 db에 저장하는 controller입니다.(db에 저장후에는 자유게시판 list페이지로 redirect하였습니다.)
	@RequestMapping("/freeBoardWrite")
	public ModelAndView freeBoardWrite(HttpServletRequest request) {
		System.out.println("freeBoardWrite()");
		ModelAndView mav=new ModelAndView();
		FreeBoardDTO dto=new FreeBoardDTO();
		dto.setbName(request.getParameter("bName"));
		dto.setbPassword(request.getParameter("bPassword"));
		dto.setbTitle(request.getParameter("bTitle"));
		dto.setbContent(request.getParameter("bContent"));
		dao.freeBoardInsert(dto);
		mav.setViewName("redirect:/freeBoard/freeBoardList");
		return mav;
	}
	
	//게시판의 게시물의 내용을 볼수있게 ModelAndView객체에 설정해주는 controller입니다.
	@RequestMapping("/freeBoardView")
	public ModelAndView freeBoardView(HttpServletRequest request) {
		System.out.println("freeBoardView()");
		ModelAndView mav=new ModelAndView();
		int bNum=Integer.parseInt(request.getParameter("bNum"));
		mav.addObject("dto", dao.freeBoardView(bNum));
		mav.setViewName("freeBoard/freeBoardView");
		return mav;
	}
	
	//게시물를 삭제하는 controller입니다.
	@RequestMapping("/freeBoardDelete")
	public ModelAndView freeBoardDelete(HttpServletRequest request) {
		System.out.println("freeBoardDelete()");
		ModelAndView mav= new ModelAndView();
		int bNum=Integer.parseInt(request.getParameter("bNum"));
		dao.freeBoardDelete(bNum);
		mav.setViewName("redirect:/freeBoard/freeBoardList");
		return mav;
	}
	
	//게시물을 수정할때 보여지는 page에 필요한 데이터를 dao로부터 조회하여 ModelAndView객체에 삽입하여주는 controller입니다.
	@RequestMapping("/freeBoardModifyView")
	public ModelAndView freeBoardModifyView(HttpServletRequest request) {
		System.out.println("freeBoardModifyView()");
		ModelAndView mav=new ModelAndView();
		int bNum=Integer.parseInt(request.getParameter("bNum"));
		mav.addObject("dto", dao.freeBoardView(bNum));
		mav.setViewName("freeBoard/freeBoardModifyView");
		return mav;
	}
	
	//게시물 수정페이지에서 수정 된 게시물을 db에 저장하는 controller입니다.
	@RequestMapping("/freeBoardModify")
	public ModelAndView freeBoardModify(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("freeBoardModify()");
		ModelAndView mav=new ModelAndView();
		request.setCharacterEncoding("utf-8");
		int bNum=Integer.parseInt(request.getParameter("bNum"));
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		String bPassword="";
		int bGroup=0;
		int bStep=0;
		int bIndent=0;
		FreeBoardDTO dto=new FreeBoardDTO(bNum, bName, bTitle, bPassword, bContent, bGroup, bStep, bIndent);
		dao.freeBoardModify(dto);
		mav.setViewName("redirect:/freeBoard/freeBoardList");
		return mav;
	}
	
	//게시물에 답글을 생성할때 보여지는 페이지를 ModelAndView객체에 삽입하여 주는 controller입니다.
	@RequestMapping("/freeBoardReplyView")
	public ModelAndView freeBoardReplyView(HttpServletRequest request) {
		System.out.println("freeBoardReplyView()");
		ModelAndView mav=new ModelAndView();
		int bNum=Integer.parseInt(request.getParameter("bNum"));
		mav.addObject("dto", dao.freeBoardView(bNum));
		mav.setViewName("freeBoard/freeBoardReplyView");
		return mav;
	}
	
	//답글 페이지에서 작성된 답글을 db에 저장하여 주는 controller입니다.
	@RequestMapping("/freeBoardReply")
	public ModelAndView freeBoardReply(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("freeBoardReply()");
		ModelAndView mav=new ModelAndView();
		request.setCharacterEncoding("utf-8");
		int bNum=Integer.parseInt(request.getParameter("bNum"));
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		String bPassword=request.getParameter("bPassword");
		int bGroup=Integer.parseInt(request.getParameter("bGroup"));
		int bStep=Integer.parseInt(request.getParameter("bStep"));
		int bIndent=Integer.parseInt(request.getParameter("bIndent"));
		FreeBoardDTO dto=new FreeBoardDTO(bNum, bName, bTitle, bPassword, bContent, bGroup, bStep, bIndent);
		dao.freeBoardReply(dto);
		
		mav.setViewName("redirect:/freeBoard/freeBoardList");
		return mav;
	}
	
	//게시물을 수정,삭제시에 게시물의 비밀번호를 체크하여 주는 ajax에 필요한 controller입니다.
	//이 controller에서 보여지는 page는 사용자가 볼수없으며 그 page의 데이터만을 조회하여 게시물의 비밀번호와 수정,삭제시에 입력한 비밀번호가 동일한지 체크하는 부분입니다.
	@RequestMapping("/pwServerCheck")
	ModelAndView pwServerCheck(HttpServletRequest request) {
		System.out.println("pwServerCheck()");
		ModelAndView mav=new ModelAndView();
		int bNum=Integer.parseInt(request.getParameter("bNum"));
		String bPassword=request.getParameter("bPassword");
		FreeBoardDTO dto=new FreeBoardDTO(bNum, bPassword);
		int result=dao.pwServerCheck(dto);
		mav.addObject("result", result);
		mav.setViewName("freeBoard/freeBoardFetch");
		return mav;
	}

}
