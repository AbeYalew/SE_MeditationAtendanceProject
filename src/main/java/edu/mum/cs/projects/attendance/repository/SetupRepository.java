package edu.mum.cs.projects.attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.Setup;

@Repository
public interface SetupRepository extends JpaRepository<Setup, Integer> {
	List<Setup> findAll();
}
