package edu.mum.cs.projects.attendance.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.projects.attendance.domain.entity.Role;
import edu.mum.cs.projects.attendance.domain.entity.Users;
import edu.mum.cs.projects.attendance.service.FacultyService;
import edu.mum.cs.projects.attendance.service.StudentService;


@Controller
//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class WelcomeController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private FacultyService facultyService;
	
    @RequestMapping("/welcome")
    public String dashboard(Model model){
    	
    	Users user = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String has_Role = user.getRoles().getRole();    	
    	String userName = "";
    	System.out.println(user.getEmail());
    	System.out.println(user.getFacultyId());
    	
    	if(has_Role.equals("STUDENT")){
		 userName = studentService.getStudentsById(user.getStudentId()).getLastName();
    	}
    	else if((has_Role.equals("FACULTY"))){
    		System.out.println(user.getFacultyId());
    		userName = 	facultyService.getFacultyById(user.getFacultyId()).getLastName();
    		
    	}
    	else{
    		userName = "Admin";
    	}
		model.addAttribute("userName", userName);
		
        return "welcome";
    }
}
