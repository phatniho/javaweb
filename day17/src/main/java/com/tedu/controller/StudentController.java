package com.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.pojo.Student;

@Controller
public class StudentController {

	@RequestMapping("/findAll")
	public String findAll(Model model, Student s1) {
		Model stu = model.addAttribute(s1);
		System.out.println(stu);
		return "findall";
	}
}
