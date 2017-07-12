package edu.mum.cs.projects.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.entity.Enrollment;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.repository.EnrollmentRepository;
import edu.mum.cs.projects.attendance.repository.StudentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	@Autowired
	EnrollmentRepository enrollmentRepository;

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Iterable<Enrollment> getEnrolledCoursesByStudentId(String id) {
		Student student = studentRepository.findBystudentId(id);
		return enrollmentRepository.findByStudent(student);
	}

}
