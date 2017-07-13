package edu.mum.cs.projects.attendance.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.attendance.domain.StudentAttendance;
import edu.mum.cs.projects.attendance.domain.entity.AcademicBlock;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.service.AttendanceService;
import edu.mum.cs.projects.attendance.service.CourseService;
import edu.mum.cs.projects.attendance.service.EnrollmentService;
import edu.mum.cs.projects.attendance.service.StudentService;
import edu.mum.cs.projects.attendance.util.DateUtil;
import edu.mum.cs.projects.attendance.util.IDNumberUtil;




@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentAttendanceController {
	
	@Autowired
	CourseService courseService;

	@Autowired
	AttendanceService attendanceService;

	@Autowired
	StudentService studentService;
	
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
    
    @RequestMapping(value = "/attendance/student/{cofferingid}", method = RequestMethod.GET)
	public String getAttendanceRecordsStudent(@PathVariable("cofferingid") long cofferingid, Model model,Authentication authentication) {

		CourseOffering coffering = courseService.getCourseOfferingbyID(cofferingid);

		AcademicBlock block = courseService.getAcademicBlock(DateUtil.convertDateToString(coffering.getStartDate()));
		coffering.setBlock(block);
		
		String studentId = IDNumberUtil.convertToStudentId(Long.valueOf(authentication.getName()));

		Student student = studentService.getStudentsById(studentId);

		List<StudentAttendance> studentAttendance = attendanceService
					.retrieveStudentAttendanceRecords(coffering);
		
		if(studentAttendance == null){
			return "redirect:/student/Courselist?attendance=none";			
		}
		
		
		studentAttendance = studentAttendance.stream().filter(a -> a.getStudent().equals(student)).collect(Collectors.toList());
		
		model.addAttribute("studentAttendance", studentAttendance);
		model.addAttribute("block", block);

		return "studentCourseOfferingAttendance";
	}

}


