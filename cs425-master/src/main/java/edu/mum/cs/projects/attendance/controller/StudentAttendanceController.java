package edu.mum.cs.projects.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.service.CourseService;

import java.util.ArrayList;
import java.util.List;



@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentAttendanceController {
    @Autowired
    CourseService courseService;

   

    @RequestMapping(value = "/my/courselist")
    public String getStudentCourseList(String studentid, Model model) {
    	List<CourseOffering> courseOfferings = courseService.getCourseOfferings("2017-06-26");
		model.addAttribute("courseOfferings", courseOfferings);

		return "studentCourseList";
    }
    @RequestMapping(value = "/my/attendance")
    public String getStudentAttendanceforAcourse(String offeringid,String studentid, Model model) {

//       

      //  model.addAttribute("students",students);
        return "studentAttendance";
    }

}


