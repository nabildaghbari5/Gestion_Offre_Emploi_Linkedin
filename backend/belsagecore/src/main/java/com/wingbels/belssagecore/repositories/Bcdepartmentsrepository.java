package com.wingbels.belssagecore.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bcdepartments;


@Repository
public interface Bcdepartmentsrepository extends JpaRepository<Bcdepartments, Long>, JpaSpecificationExecutor<Bcdepartments> {

	public Optional<Bcdepartments> findByCodedept(Long codedepartment);
	public void deleteByCodedept(Long codedepartment);
    
}
