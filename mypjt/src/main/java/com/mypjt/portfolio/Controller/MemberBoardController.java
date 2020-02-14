package com.mypjt.portfolio.Controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mypjt.portfolio.DAOInterface.MemberBoardDAOInterface;
import com.mypjt.portfolio.DTO.MemberBoardDTO;

@Controller
@RequestMapping("/memberBoard")   //web.xml에서 servlet mapping을 이용하여 controller에 접근할때 url앞부분(회원게시판을 이용할경우 고정적인 url부분입니다.)
public class MemberBoardController {
	
	MemberBoardDAOInterface dao;    //다형성을 이용하여 dao의 수정 및 교체를 용이하게 하기위하여 interface로 선언.
	
	public void setDao(MemberBoardDAOInterface dao) {  //controller에서 db에 접근하여 처리할 dao를 주입시켜주는 setter입니다.(DAO-servlet-context.xml에서  주입하여 줍니다.)
		this.dao = dao;
	}
	
	//회원 게시만 모든 페이지에서 login상태를 체크하여 회원게시판 사용여부를 판단하는 메소드입니다.
	//ajax를 활용하지않고 javascript를 이용하여 세션에 login정보가 없을경우 경고창을 띄운 후 이전페이지로 돌아가게합니다.
	public boolean loginCheck(HttpServletRequest request, ModelAndView mav) {
		System.out.println("loginCheck()");
		HttpSession session=request.getSession();
		if(session.getAttribute("sessiondto")==null) {
			mav.addObject("checkValuse","1");
			mav.setViewName("memberBoard/memberBoardCheck");
			return false;
		}
		return true;
	}
	
	//회원 게시판의 게시물list를 db에서 가져와 페이지당 10개씩 보여줄수있게 처리하여주는 controller입니다. 
	@RequestMapping("/memberBoardList")
	public ModelAndView memberBoardList(HttpServletRequest request) {
		System.out.println("memberBoardList()");
		ModelAndView mav=new ModelAndView();
		if(loginCheck(request, mav)) {
			int pageNum=1;
			String stringPageNum=request.getParameter("pageNum");
			if(!(stringPageNum==null||stringPageNum=="1"))pageNum=Integer.parseInt(stringPageNum);
			int max=dao.getMax();
			if(max%10>0) {max=max/10+1;}
			else {max=max/10;}
			
			int endPage=max;
			int startPage=1;
			
			if(max>10) {
				if(pageNum>max-4)startPage=max-9;
				else if(pageNum>=7)startPage=pageNum-5;
				if(pageNum<7)endPage=10;
				else if(pageNum+4<max)endPage=pageNum+4;
			}
			mav.addObject("max", max);
			mav.addObject("startPage", startPage);
			mav.addObject("endPage", endPage);
			mav.addObject("pageNum",pageNum);
			
			mav.addObject("dtos", dao.memberBoardList(pageNum));
			mav.setViewName("memberBoard/memberBoardList");
		}
		return mav;
	}
	
	//회원게시판에서 게시물을 작성할수있는 view페이지를 ModelAndView객체에 삽입하여주는 controller입니다.
	@RequestMapping("/memberBoardWriteView")
	public ModelAndView memberBoardWriteView(HttpServletRequest request) {
		System.out.println("memberBoardWriteView()");
		ModelAndView mav=new ModelAndView();
		
		if(loginCheck(request, mav)) {
			mav.setViewName("memberBoard/memberBoardWriteView");
		}
		return mav;
	}
	
	//회원게시판에서 게시물을 작성한 데이터를 db에 저장하여 주는 controller입니다.
	@RequestMapping("/memberBoardWrite")
	public ModelAndView memberBoardWrite(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("memberBoardWrite()");
		ModelAndView mav= new ModelAndView();
		request.setCharacterEncoding("utf-8");
		
		
		
		if(loginCheck(request, mav)) {
			String mEmail=request.getParameter("mEmail");
			String mNickName=request.getParameter("mNickName");
			String mbTitle=request.getParameter("mbTitle");
			String mbContent=request.getParameter("mbContent");
			MemberBoardDTO dto=new MemberBoardDTO(mEmail,mNickName,mbTitle,mbContent);
			dao.memberBoardWrite(dto);
			mav.setViewName("redirect:/memberBoard/memberBoardList");
		}
		return mav;
	}
	
	//회원게시판의 게시물을 보여줄수있게 게시물의 번호를 이용하여 db에서 데이터를 가져와 ModelAndView객체에 데이터와 viewpage명을 삽입하여주는 controller입니다.
	@RequestMapping("/memberBoardView")
	public ModelAndView memberBoardView(HttpServletRequest request) {
		System.out.println("memberBoardWrite()");
		ModelAndView mav=new ModelAndView();
		
		if(loginCheck(request, mav)) {
			int mbNum=Integer.parseInt(request.getParameter("mbNum"));
			mav.addObject("dto",dao.memberBoardView(mbNum));
			mav.setViewName("memberBoard/memberBoardView");
		}
		
		return mav;
	}
	
	//회원 게시판의 게시물을 수정할때 보여지는 페이지를 ModelAndView 객체에 삽입하여주는 controller입니다.
	@RequestMapping("/memberBoardModifyView")
	public ModelAndView memberBoardModifyView(HttpServletRequest request) {
		System.out.println("memberBoardModifyView()");
		ModelAndView mav=new ModelAndView();
		
		if(loginCheck(request, mav)) {
			int mbNum=Integer.parseInt(request.getParameter("mbNum"));
			mav.addObject("dto",dao.memberBoardView(mbNum));
			mav.setViewName("memberBoard/memberBoardModifyView");
		}
		return mav;
	}
	
	//회원게시판의 게시물수정페이지에서 수정된 데이터를 db에 저장하여주는 controller입니다.
	@RequestMapping("/memberBoardModify")
	public ModelAndView memberBoardModify(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("memberBoardModify()");
		ModelAndView mav= new ModelAndView();
		request.setCharacterEncoding("utf-8");
		
		if(loginCheck(request, mav)) {
			int mbNum=Integer.parseInt(request.getParameter("mbNum"));
			String mbTitle=request.getParameter("mbTitle");
			String mbContent=request.getParameter("mbContent");
			MemberBoardDTO dto=new MemberBoardDTO(mbNum,mbTitle,mbContent);
			dao.memberBoardModify(dto);
			mav.setViewName("redirect:/memberBoard/memberBoardList");
		}
		
		return mav;
	}
	
	//회원 게시판의 게시물을 삭제할때 사용되는 controller입니다.
	@RequestMapping("/memberBoardDelete")
	public ModelAndView memberBoardDelete(HttpServletRequest request) {
		System.out.println("memberBoardDelete()");
		ModelAndView mav=new ModelAndView();
		
		if(loginCheck(request, mav)) {
			int mbNum=Integer.parseInt(request.getParameter("mbNum"));
			dao.memberBoardDelete(mbNum);
			mav.setViewName("redirect:/memberBoard/memberBoardList");
		}
		return mav;
	}
	
	
	
	
	
	
	
}
