package edu.mum.cs.projects.attendance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.projects.attendance.domain.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	Optional<Users> findByName(String username);

	Users findByStudentId(String studentId);

	Users findById(int userId);

}
