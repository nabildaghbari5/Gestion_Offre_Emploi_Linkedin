package com.wingbels.belssagecore.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bcdocuments;
import com.wingbels.belssagecore.entities.Bcemployees;

@Repository
public interface Bcdocumentsrepository extends JpaRepository<Bcdocuments, Long> {

	public Optional<Bcdocuments> findByIddocument(Long idbcdocument);

	public List<Bcdocuments> findByEmployee(Bcemployees emp);
	public String findFileTypeByFileName(String fileName);

}
