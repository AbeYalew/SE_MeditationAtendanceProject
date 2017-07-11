/*package edu.mum.cs.projects.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;



@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute("student") Student student , BindingResult bind, Model model) {
        if(bind.hasErrors()){
            return "addStudent";
        }
        studentService.addStudent(student);
        //request.getSession().setAttribute("successMessage", "Profile successfully updated");
        return "redirect:/student/list";
    }
    @RequestMapping(value = "/student/edit/{id}", method = RequestMethod.POST)
    public String editStudent(Student student, @PathVariable long id, Model model) {

        studentService.updateStudents(id,student);
        //request.getSession().setAttribute("successMessage", "Profile successfully updated");
        return "redirect:/student/list";
    }
   
   
    
}
*/