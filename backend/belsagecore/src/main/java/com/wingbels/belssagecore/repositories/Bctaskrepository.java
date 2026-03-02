package com.wingbels.belssagecore.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bctask;

@Repository
public interface Bctaskrepository extends JpaRepository<Bctask, Long>, JpaSpecificationExecutor<Bctask> {

	public Optional<Bctask> findByIdtask(Long idbctask);

	public List<Bctask> findByEmployee(Bcemployees emp);

}
