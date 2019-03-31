package com.examples.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	@RequestMapping(value="/addEmployee.html", method=RequestMethod.GET)
	public ModelAndView addEmp() {
		ModelAndView model=new ModelAndView("AddEmployee");
		
		return model;
	}
	
	@RequestMapping(value="/successForm.html", method=RequestMethod.POST)
	public ModelAndView welcomeForm(@RequestParam("name") String name,@RequestParam("dept") String dept) {
		ModelAndView model=new ModelAndView("AddSuccess");
		model.addObject("msg","Name : "+name+", Dept : "+dept);
		return model;
	}
}
