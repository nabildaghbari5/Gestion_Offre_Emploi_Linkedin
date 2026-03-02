package com.wingbels.belssagecore.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.wingbels.belssagecore.entities.Bcemployees;

@Repository
public interface Bcemployeesrepository extends JpaRepository<Bcemployees, Long>, JpaSpecificationExecutor<Bcemployees> {
	public Optional<Bcemployees> findByIdemployee(Long idemployee);
}
