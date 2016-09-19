package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberDAO;
import member.model.MemberDBBean;

@Controller
public class MemberController {
	
	private MemberDAO memberDAO;
	
	public void setMemberDAO (MemberDAO memberDAO){
		this.memberDAO = memberDAO;
	}
	
	@RequestMapping(value="/insert.member")
	public ModelAndView insertFormMember(HttpServletRequest arg0, HttpServletResponse arg1)throws Exception{
		System.out.println("MemberController_insertFormMember() 실행");
		return new ModelAndView("member/insertMemberForm.jsp");
		
	}
	
	@RequestMapping(value="/insertPro.member")
	public ModelAndView insertProMember(HttpServletRequest arg0, HttpServletResponse arg1)throws Exception{
		System.out.println("MemberController_insertProMember() 실행");
		
		MemberDBBean dto = new MemberDBBean();
		dto.setId(arg0.getParameter("id"));
		dto.setPassword(arg0.getParameter("password"));
		dto.setName(arg0.getParameter("name"));
		dto.setGender(arg0.getParameter("gender"));
		dto.setBirth(arg0.getParameter("birth"));
		dto.setInterest(arg0.getParameter("interest"));
		memberDAO.insertMember(dto);
		return new ModelAndView("index.jsp");
	}
}
