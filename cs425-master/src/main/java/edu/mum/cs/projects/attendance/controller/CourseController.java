package edu.mum.cs.projects.attendance.controller;

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

import edu.mum.cs.projects.attendance.domain.StudentAttendance;
import edu.mum.cs.projects.attendance.domain.entity.AcademicBlock;
import edu.mum.cs.projects.attendance.domain.entity.CourseOffering;
import edu.mum.cs.projects.attendance.service.AttendanceService;
import edu.mum.cs.projects.attendance.service.CourseService;
import edu.mum.cs.projects.attendance.util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CourseController {
	@Autowired
	CourseService courseService;

	@Autowired
	AttendanceService attendanceService;

	@RequestMapping(value = "/courseOffering/list/{beginDate}", method = RequestMethod.GET)
	public String getAllCourse(@PathVariable("beginDate") String beginDate,  Model model) {

		List<CourseOffering> courseOfferings = courseService.getCourseOfferings(beginDate);
		model.addAttribute("courseOfferings", courseOfferings);

		return "courseOfferings";
	}

	@RequestMapping(value = "/courseOffering/getrecord/{cofferingid}", method = RequestMethod.GET)
	public String getAttendanceRecords(@PathVariable("cofferingid") long cofferingid, Model model) {

		CourseOffering coffering = courseService.getCourseOfferingbyID(cofferingid);
		AcademicBlock block = courseService.getAcademicBlock(DateUtil.convertDateToString(coffering.getStartDate()));
		coffering.setBlock(block);
		List<StudentAttendance> studentAttendance = attendanceService.retrieveStudentAttendanceRecords(coffering);
		model.addAttribute("studentAttendance", studentAttendance);
		model.addAttribute("block",block);

		return "attendanceListStudent";
	}

	
	@RequestMapping(value = "/getallblocks", method = RequestMethod.GET)
	public String getAllAcadamicBlocks( Model model) {

		List<AcademicBlock> blocks=courseService.getAllAcademicBlock();
		model.addAttribute("blocks",blocks);

		return "academicblocks";
	}
	
}
