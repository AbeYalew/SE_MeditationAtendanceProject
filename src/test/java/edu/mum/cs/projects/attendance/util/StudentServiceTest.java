package edu.mum.cs.projects.attendance.util;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.mum.cs.projects.attendance.AttendanceReport;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.repository.StudentRepository;
import edu.mum.cs.projects.attendance.service.StudentService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes=AttendanceReport.class,webEnvironment=WebEnvironment.NONE)
public class StudentServiceTest {
//	@Autowired
//	StudentService studentService;
//	@MockBean
//	StudentRepository studentRepository;
	
	@Test
	public void testGetStudentsById() {
//		when(studentRepository.findBystudentId(null)).thenReturn(null);
//		
//		Student studentMock = mock(Student.class);
//		when(studentMock.getId()).thenReturn("000-98-0003");		
//		when(studentRepository.findBystudentId("000-98-0003")).thenReturn(studentMock);
//		assertTrue("error", studentService.getStudentsById(null)==null);
//		assertTrue("error", studentService.getStudentsById("000-98-0003").getId().equals("000-98-0003"));
	}

}
