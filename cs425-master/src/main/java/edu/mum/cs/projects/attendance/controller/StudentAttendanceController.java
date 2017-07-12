package edu.mum.cs.projects.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.repository.EnrollmentRepository;
import edu.mum.cs.projects.attendance.repository.StudentRepository;
import edu.mum.cs.projects.attendance.service.CourseService;
import edu.mum.cs.projects.attendance.service.EnrollmentService;
import edu.mum.cs.projects.attendance.service.StudentService;




@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentAttendanceController {
    @Autowired
    EnrollmentService enrollmentService;

    @RequestMapping(value = "/my/courselist")
    public String getStudentCourseList(String studentid, Model model) { 	
    	
		model.addAttribute("enrolledCourses", enrollmentService.getEnrolledCoursesByStudentId(StudentService.sampleStudentId));	

		return "studentCourseList";
    }

    @RequestMapping(value = "/my/attendance")
    public String getStudentAttendanceforAcourse(String offeringid,String studentid, Model model) {

        return "studentAttendance";
    }

}


