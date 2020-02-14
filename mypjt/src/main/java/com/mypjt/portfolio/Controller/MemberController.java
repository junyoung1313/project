package com.mypjt.portfolio.Controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mypjt.portfolio.DAOInterface.MemberDAOInterface;
import com.mypjt.portfolio.DTO.MemberDTO;

@Controller
@RequestMapping("/member")  //web.xml에서 servlet mapping을 이용하여 controller에 접근할때 url앞부분(회원게시판을 이용할경우 고정적인 url부분입니다.)
public class MemberController {
	
	MemberDAOInterface dao;  //다형성을 이용하여 dao의 수정 및 교체를 용이하게 하기위하여 interface로 선언.
	
	public void setDao(MemberDAOInterface dao) {  //controller에서 db에 접근하여 처리할 dao를 주입시켜주는 setter입니다.(DAO-servlet-context.xml에서  주입하여 줍니다.)
		this.dao = dao;
	}
	
	
	//회원가입 페이지를 ModelAndView객체에 삽이하여주는 controller입니다.
	@RequestMapping("/memberInsertView")
	public ModelAndView memberInsertView() {
		System.out.println("memberInsertView()");
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("member/memberInsertView");
		return mav;
		
	}
	
	//회원 가입페이지에서 입력된 데이터를 db에 저장하는 controller입니다.
	@RequestMapping("/memberInsert")
	public ModelAndView memberInsert(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("memberInsert()");
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		MemberDTO dto=new MemberDTO();
		String mEmail=request.getParameter("mEmail");
		String mPassword=request.getParameter("mPassword1");
		String mNickName=request.getParameter("mNickName");
		
		dto.setmEmail(mEmail);
		dto.setmPassword(mPassword);
		dto.setmNickName(mNickName);
		dao.memberInsert(dto);
		mav.setViewName("redirect:../freeBoard/freeBoardList");
		return mav;
	}
	
	//로그인 페이지를 ModelAndView객체에 삽입하여 주는 controller입니다.(현재 로그인 페이지는 없으며 모든 페이지에서 상단 memberNav부분에서 로그인 가능하게하였습니다.)
	@RequestMapping("/memberLoginView")
	public ModelAndView memberLoginView(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("memberLoginView");
		ModelAndView mav=new ModelAndView();
		mav.addObject("ch", request.getParameter("ch"));
		mav.setViewName("member/memberLoginView");
		return mav;
	}
	
	//로그인시에 회원 데이터를 입력받아 db에서 조회하여 세션에 로그인 정보를 입력하여주는 controller입니다.
	@RequestMapping("/memberLogin")
	public ModelAndView MemberLogin(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("memberLogin()");
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		MemberDTO dto=new MemberDTO();
		String mEmail=request.getParameter("mEmail");
		String mPassword=request.getParameter("mPassword");
		
		
		dto.setmEmail(mEmail);
		dto.setmPassword(mPassword);
		
		MemberDTO isLogin=dao.memberLogin(dto);
		
		HttpSession session=request.getSession(); 
		session.setAttribute("sessiondto", isLogin);
		mav.setViewName("redirect:/freeBoard/freeBoardList");
		return mav;
	}
	
	//세션에서 로그인 정보를 없애주는 controller입니다.
	@RequestMapping("/memberLogout")
	public ModelAndView memberLogout(HttpServletRequest request) {
		System.out.println("memberLogout()");
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		session.invalidate();
		mav.setViewName("redirect:../freeBoard/freeBoardList");
		return mav;
	}
	
	//로그인 되어있는 세션의 회원정보를 조회하여 ModelAndView객체에 삽입하여주는 controller입니다.
	@RequestMapping("/memberMyInfo")
	public ModelAndView memberMyInfo(HttpServletRequest request) {
		System.out.println("memberMyInfo()");
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		MemberDTO dto=new MemberDTO();
		dto=(MemberDTO) session.getAttribute("sessiondto");
		mav.addObject("dto", dto);
		mav.setViewName("member/memberMyInfo");
		return mav;
	}
	
	//회원 정보를 출력하여주는 페이지를 ModelAndView객체에 삽입하여 주는 controller입니다.(dao를 사용하여 db에서 조회하지않고 세션에있는 정보를 출력하였습니다.)
	@RequestMapping("/memberModifyView")
	public ModelAndView memberModifyView(HttpServletRequest request) {
		System.out.println("memberModifyView()");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/memberModifyView");
		return mav;
	}
	
	//회원정보수정페이지에서 수정된 회원정보를 db에서 수정하여 주는 controller입니다.(이 controller에서는 닉네임만 변경합니다.)
	@RequestMapping("/memberModify")
	public ModelAndView memberModify(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("memberModify()");
		ModelAndView mav=new ModelAndView();
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String mEmail=request.getParameter("mEmail");
		String mPassword=request.getParameter("mPassword");
		String mNickName=request.getParameter("mNickName");
		MemberDTO dto=new MemberDTO(mEmail, mPassword, mNickName);
		dao.memberUpdate(dto);
		session.setAttribute("sessiondto", dto);
		mav.setViewName("redirect:../freeBoard/freeBoardList");
		return mav;
	}
	
	
	//회원탈퇴할때 비밀번호를 입력받는 페이지를 ModelAndView객체에 삽입하여주는 controller입니다.
	@RequestMapping("/memberDeleteView")
	public ModelAndView memberDeleteView() {
		System.out.println("memberDeleteView()");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/memberDeleteView");
		return mav;
	}
	
	
	
	
	//회원탈퇴페이지에서 입력받은 페이지에서 입력받은 비밀번호를 ajax로 컨트롤러에 오기전에 비교하여 탈퇴처리하는 controller입니다.(탈퇴 처리 후 세션은 만료됩니다.)
	@RequestMapping("/memberDelete")
	public ModelAndView memberDelete(HttpServletRequest request) {
		System.out.println("memberDelete()");
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		String mEmail=request.getParameter("mEmail");
		String mPassword=request.getParameter("mPassword");
		
		MemberDTO dto=new MemberDTO(mEmail, mPassword);
		dao.memberDelete(dto);
		session.invalidate();
		mav.setViewName("redirect:../freeBoard/freeBoardList");
		return mav;
	}
	
	//회원 비밀번호를 변경하는 페이지를 ModelAndView객체에 삽입하여주는 controller입니다.
	@RequestMapping("/memberPWChangeView")
	public ModelAndView memberPWChangeView() {
		System.out.println("memberPWChangeView()");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/memberPWChangeView");
		return mav;
	}
	
	//회원 비밀번호  변경페에지에서 ajax로 비밀번호를 확인하여 비밀번호 변경을 진행하는 controller입니다.
	@RequestMapping("/memberPWChange")
	public ModelAndView memberPWChange(HttpServletRequest request) {
		System.out.println("memberPWChange()");
		ModelAndView mav=new ModelAndView();
		String mEmail=request.getParameter("mEmail");
		String mPassword=request.getParameter("mPassword");
		MemberDTO dto=new MemberDTO(mEmail, mPassword);
		String mpassword1=request.getParameter("mPassword1");
		dto.setmPassword(mpassword1);
		dao.memberPWChange(dto);
		HttpSession session=request.getSession();
		session.invalidate();
		mav.setViewName("redirect:../freeBoard/freeBoardList");
		return mav;
	}
	
	//ajax로 회원 Email의 중복확인할때 사용하는 controller입니다.(사용자에겐 페이지가 보여지지 않으며 페이지의 데이터로만 중복확인을 합니다.)
	@RequestMapping("/checkId")
	public ModelAndView checkId(HttpServletRequest request) {
		System.out.println("checkId()");
		ModelAndView mav = new ModelAndView();
		String mEmail=request.getParameter("getStr");
		int result=0;
		if(mEmail!=null) {
			result=dao.checkId(mEmail);
		}
		mav.addObject("result", result);
		mav.setViewName("member/checkEnN");
		return mav;
	}
	
	//ajax로 회원 닉네임의 중복확인할때 사용하는 controller입니다.(사용자에겐 페이지가 보여지지 않으며 페이지의 데이터로만 중복확인을 합니다.)
	@RequestMapping("/checkNick")
	public ModelAndView checkNick(HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("checkNick()");
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		String mNickName=request.getParameter("getStr");
		int result=0;
		if(mNickName!=null) {
			result=dao.checkmNickName(mNickName);
		}
		mav.addObject("result", result);
		mav.setViewName("member/checkEnN");
		return mav;
	}
	
	//ajax로 회원 비밀번호의 동일을 판단할때 사용하는 controller입니다.(사용자에겐 페이지가 보여지지 않으며 페이지의 데이터로만 중복확인을 합니다.)
	@RequestMapping("/checkPw")
	public ModelAndView checkPw(HttpServletRequest request) {
		System.out.println("checkPw()");
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		String mEmail=((MemberDTO)session.getAttribute("sessiondto")).getmEmail();
		String mPassword=request.getParameter("getStr");
		
		MemberDTO dto=new MemberDTO(mEmail, mPassword);
		int result=0;
		if(mPassword!=null) {
			result=dao.checkmPassword(dto);
		}
		mav.addObject("result", result);
		mav.setViewName("member/checkEnN");
		return mav;
	}
	
	//로그인시에 email 또는 password가 변경 될때마다 서버에서 로그인이 가능한지 판단하여줍니다.(로그인할 회원정보가 있는지 탈퇴한 회원인지 판단할떄 사용합니다.)
	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(HttpServletRequest request) {
		System.out.println("checkLogin()");
		ModelAndView mav = new ModelAndView();
		String mEmail=request.getParameter("mEmail");
		String mPassword=request.getParameter("mPassword");
		MemberDTO dto=new MemberDTO(mEmail, mPassword);
		
		//result의 값이 0이면 email또는 password를 확인하여주세요 라는 경고장이 뜹니다.
		//result의 값이 1이면 로그인이 가능한 상태이므로 로그인처리를 합니다.
		//result의 값이 2이면 탈퇴한 회원으로 분류되어 로그인 할 수 없습니다 라는 경고창이 뜹니다.
		int result=0;
		if(mPassword!=null) {
			result=dao.checkmPassword(dto);
			if(dao.memberIsSelect(dto)==0&&result==1) {
				result=2;
			}
		}
		mav.addObject("result", result);
		mav.setViewName("member/checkEnN");
		return mav;
	}
}
