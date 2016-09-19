package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import login.model.LoginModel;
import member.model.MemberDAO;
import member.model.MemberDBBean;

@Controller
public class MemberController {

	private MemberDAO memberDAO;
	private LoginModel loginModel;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	@RequestMapping(value = "/insert.member")
	public ModelAndView insertFormMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_insertFormMember() ����");
		return new ModelAndView("member/insertMemberForm.jsp");

	}

	@RequestMapping(value = "/insertPro.member")
	public ModelAndView insertProMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MemberController_insertProMember() ����");

		/*
		 * arg0.setCharacterEncoding("UTF-8");
		 * arg1.setCharacterEncoding("UTF-8");
		 */

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
	
	@RequestMapping(value = "/login.member")
	public ModelAndView loginMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		String saveId = arg0.getParameter("saveId");
		
		MemberDBBean dto = new MemberDBBean();
		dto.setId(arg0.getParameter("id"));
		dto.setPassword(arg0.getParameter("password"));
		loginModel.setDto(dto);
		
		HashMap<Object, MemberDBBean> resMap = loginModel.loginChk();
		
		//���� �м�??
		Set<Map.Entry<Object, MemberDBBean>> entries = resMap.entrySet();
		// set �� iterator ��ȯ
		Iterator<Entry<Object, MemberDBBean>> i = entries.iterator();
		// iterator ���� �ֿܼ� ����Ѵ�.
		Object key = null;
		MemberDBBean resDTO = null;
		while (i.hasNext()) {
			//Ű���� �α��� ����� , �������� memberDTO
			Entry<Object, MemberDBBean> entry = i.next();
			key = entry.getKey();
			resDTO = entry.getValue();

		}
		String url = ""; //���� �ּ� ��
		switch ((int)key) {
		case LoginModel.OK:
			System.out.println("�α��� ����");
			
			//��Ű
			Cookie ck  = new Cookie("saveId",resDTO.getId());
			if(saveId != null){
				ck.setMaxAge(12*60*60);
			}else{
				ck.setMaxAge(0);
			}
			arg1.addCookie(ck);
			
			//memberDTO �������� ������
			HttpSession session = arg0.getSession();
			session.setAttribute("memberDTO", resDTO);
			
			url = "index.jsp";
			break;
		case LoginModel.NOT_ID:
			System.out.println("���̵� Ʋ��");
			break;
		case LoginModel.NOT_PW:
			System.out.println("��й�ȣ Ʋ��");
			break;
		case LoginModel.ERR:
			System.out.println("DB����");

			break;

		default:
			break;
		}

		return new ModelAndView(url);
	}
	
	@RequestMapping(value="/logout.member")
	public ModelAndView logoutMember(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		HttpSession session = arg0.getSession();
		session.invalidate();
		return new ModelAndView("index.jsp");
	}
}
