package edu.mum.cs.projects.attendance.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.projects.attendance.domain.entity.Faculty;
import edu.mum.cs.projects.attendance.domain.entity.Role;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.domain.entity.Users;
import edu.mum.cs.projects.attendance.service.FacultyService;
import edu.mum.cs.projects.attendance.service.StudentService;
import edu.mum.cs.projects.attendance.service.UserService;



@Controller
//@Transactional(propagation = Propagation.REQUIRES_NEW)
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public String findUser(Model model, @RequestParam String userName) {       
        model.addAttribute("user", userService.getUserByUserName(userName));
        return "userProfile";
    }
    
    @RequestMapping(value = "/user/get/{username}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable String username) {       
        model.addAttribute("user", userService.getUserByUserName(username));
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
    
    @RequestMapping(value = "/user/editStudent/{studentId}/{username}", method = RequestMethod.GET)
    public String editStudent(Model model, @PathVariable String studentId, @PathVariable String username) {
        
        model.addAttribute("user", userService.getUserByUserName(username));
        model.addAttribute("student", studentService.getStudentsById(studentId));
        return "editUser";
    }
    
    @RequestMapping(value = "/user/editFaculty/{facultyId}/{username}", method = RequestMethod.GET)
    public String editFaculty(Model model, @PathVariable Long facultyId, @PathVariable  String username) {
        
        model.addAttribute("user", userService.getUserByUserName(username));
        model.addAttribute("faculty", facultyService.getFacultyById(facultyId));
        return "editUser";
    }
                              
    @RequestMapping(value = "/user/changTofacultyRole/{id}", method = RequestMethod.POST)
    @Transactional
    public ModelAndView updateUserRole( @PathVariable int id, @RequestParam String role) {
    	
    	Users user = userService.getUserByID(id);    	
    	
    	Role roles = new Role();
    	roles.setRole(role);
    	
    	long facultyId = facultyService.getAll().size() + 1;
    	Faculty faculty = new Faculty();
        faculty.setFirstName(studentService.getStudentsById(user.getStudentId()).getFirstName());
        faculty.setLastName(studentService.getStudentsById(user.getStudentId()).getLastName());
        faculty.setId(facultyId);
        
        user.setName(faculty.getLastName()+ facultyId);
       // user.setStudentId(null);
        user.setFacultyId(facultyId);  
    	user.setRoles(roles);
        
        facultyService.createFaculty(faculty);        
        userService.createUser(user);
        ModelAndView model = new ModelAndView("confirmation");
        model.addObject("user", user);
        model.addObject("faculty", faculty);
        
        return model;
    }
    
    @RequestMapping(value = "/user/changeToStudentRole/{id}", method = RequestMethod.POST)
    @Transactional
    public ModelAndView updateRole( @PathVariable int id, @RequestParam String role) {
    	
    	Users user = userService.getUserByID(id);    	
    	
    	Role roles = new Role();
    	roles.setRole(role);
    	
    	Student student = new Student();
    	student.setFirstName(facultyService.getFacultyById(user.getFacultyId()).getFirstName());
    	student.setLastName(facultyService.getFacultyById(user.getFacultyId()).getLastName());
    	student.setStudentId("000-"+ facultyService.getFacultyById(user.getFacultyId()).getId()+"-000");
        student.setEntryDate(new Date());
    	
        user.setName(("000"+ facultyService.getFacultyById(user.getFacultyId()).getId()));
        user.setStudentId(student.getStudentId());        
        user.setFacultyId(null);
        user.setEmail(student.getLastName()+"@mum.edu");
    	user.setRoles(roles);
        
        studentService.createStudent(student);        
        userService.createUser(user);        
        ModelAndView model = new ModelAndView("confirmation");
        model.addObject("user", user);
        model.addObject("student", student);
        
        return model;
    }
   
    
}
