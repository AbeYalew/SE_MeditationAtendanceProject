package edu.mum.cs.projects.attendance.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.projects.attendance.domain.entity.CustomUserDetails;
import edu.mum.cs.projects.attendance.domain.entity.Faculty;
import edu.mum.cs.projects.attendance.domain.entity.Role;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.domain.entity.Users;
import edu.mum.cs.projects.attendance.repository.UsersRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private StudentService studentService;
	@Autowired
	private FacultyService facultyService;
	
	
	public void createUser(Users user){		
		usersRepository.save(user);
	}	
	
	public Users getUser(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = usersRepository.findByName(username);

		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}
	
	@Transactional
	public void creatUsers(){         
		Set<Role> roles = new HashSet<>();
		System.out.println("User Account for Students is created.....");
		for(Student student: studentService.getStudentsByEntry("2017-02-09 00:00:00")){
			
			Role role =  new Role();
			role.setRole("STUDENT");
			//roles.add(role);
			Users user = new Users();
			String temp = student.getStudentId();
			String userName = "";
			String[] str = temp.split("-");
			for (String st: str){
				userName += st;
			}
			user.setEmail(student.getFirstName() + student.getLastName().substring(0,1) + "@mum.edu");
			user.setStudentId(student.getStudentId());
			user.setName(userName);
			user.setPassword(student.getLastName()+"123");			
			user.setActive(1);
			
			user.setRoles(role);			
			createUser(user);			
			}
		System.out.println("User Account for Faculty is created.....");
		for(Faculty faculty: facultyService.getAll()){
			Role role =  new Role();
			role.setRole("FACULTY");
			roles.add(role);
			Users user = new Users();
			
		    user.setName(faculty.getLastName()+ faculty.getId());
		    user.setFacultyId(faculty.getId());
		    user.setEmail(faculty.getLastName() +"@mum.edu");
		    user.setActive(0);
		    user.setPassword(faculty.getLastName()+ "123");
		    user.setRoles(role);
		    createUser(user);
		}
		
	}

}
