package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value="/main.app")
	public ModelAndView goMain(){
		System.out.println("MainController.java ½ÇÇà");
		return new ModelAndView("index.jsp");
	}
	
}
