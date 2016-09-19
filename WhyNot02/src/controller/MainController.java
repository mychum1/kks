package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value="/main.app")
	public ModelAndView goMain(){//user���� ������ �̵�
		System.out.println("MainController_ goMain() ����");
		return new ModelAndView("index.jsp");
	}
	
	@RequestMapping(value="/adminMain.app")
	public ModelAndView goAdminMain(){//admin���� ������ �̵�
		System.out.println("MainController_goAdminMain() ����");
		return new ModelAndView("admin/adminMain.jsp");
	}
	
}
