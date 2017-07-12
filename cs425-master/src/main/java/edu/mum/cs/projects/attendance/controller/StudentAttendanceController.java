package edu.mum.cs.projects.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.projects.attendance.service.EnrollmentService;
import edu.mum.cs.projects.attendance.service.StudentService;




@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentAttendanceController {
    @Autowired
    EnrollmentService enrollmentService;

    @RequestMapping(value = "/my/courselist")
    public String getStudentCourseList(String studentid, Model model,Authentication authentication) { 
    	
    	
		model.addAttribute("enrolledCourses", enrollmentService.getEnrolledCoursesByStudentId(authentication.getName()));	

		return "studentCourseList";
    }

    @RequestMapping(value = "/my/attendance")
    public String getStudentAttendanceforAcourse(String offeringid,String studentid, Model model) {

        return "studentAttendance";
    }

}


