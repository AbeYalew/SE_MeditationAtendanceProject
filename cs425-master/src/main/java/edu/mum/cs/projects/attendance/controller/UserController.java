package edu.mum.cs.projects.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.attendance.service.FacultyService;
import edu.mum.cs.projects.attendance.service.StudentService;
import edu.mum.cs.projects.attendance.service.UserService;



@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public String findUser(Model model, @RequestParam String userName) {
        
        model.addAttribute("user", userService.getUser(userName));
        return "userProfile";
    }
    
    @RequestMapping(value = "/user/getStudent/{studentId}/{username}", method = RequestMethod.GET)
    public String getStudent(Model model, @PathVariable String studentId, @PathVariable String username) {
        
        model.addAttribute("user", userService.getUser(username));
        model.addAttribute("student", studentService.getStudentsById(studentId));
        return "userDetails";
    }
    
    @RequestMapping(value = "/user/getFaculty/{facultyId}/{username}", method = RequestMethod.GET)
    public String getFaculty(Model model, @PathVariable Long facultyId, @PathVariable  String username) {
        
        model.addAttribute("user", userService.getUser(username));
        model.addAttribute("faculty", facultyService.getFacultyById(facultyId));
        return "userDetails";
    }
    
    /*@RequestMapping(value = "/getUser/{role}/{studentId}/{facultyId}/{username}", method = RequestMethod.GET)
	public String getStudent(Model model,@PathVariable String role,  @PathVariable String studentId, @PathVariable Long facultyId, @PathVariable String username) {
        
		if(role.equals("STUDENT")){
		    model.addAttribute("user", userService.getUser(username));
		    model.addAttribute("student", studentService.getStudentsById(studentId));
		}
		else{
			model.addAttribute("user", userService.getUser(username));
			model.addAttribute("faculty", facultyService.getFacultyById(facultyId));	
		}
		return "userDetails";
	}*/
   
    
}
