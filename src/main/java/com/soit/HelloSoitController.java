package com.soit;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloSoitController {
	
	//controller method to view the form
	@RequestMapping("/viewForm")
	public String viewForm() {
		return "hellosoitform";
	}
	
	//controller method to process the form (read form data and data to the model)
	//binds request parameter with variable (better way)
	@RequestMapping("/processForm")
	public String processForm(@RequestParam("facultyName") String name, Model model) {
		//Convert the inserted to all caps
		name = name.toUpperCase();
		
		//Create message for the results
		String result = "Hello Professor! " + name;
		
		//Add message to the results
		model.addAttribute("message", result);
		
		return "hellosoit";
	}
	
	//original way to process request with HttpServletRequent (older, not best way)
//	public String processForm(HttpServletRequest request, Model model) {
//		//Read the request parameter from the HTML form
//		String name = request.getParameter("facultyName");
//		
//		//Convert the inserted to all caps
//		name = name.toUpperCase();
//		
//		//Create message for the results
//		String result = "Hello Professor! " + name;
//		
//		//Add message to the results
//		model.addAttribute("message", result);
//		
//		return "hellosoit";
	
//	}
}
