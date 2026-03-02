package com.wingbels.belssagecore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bccities;
import com.wingbels.belssagecore.entities.Bccountries;

@Repository
public interface Bccitiesrepository extends JpaRepository<Bccities, Long>, JpaSpecificationExecutor<Bccities> {
	List<Bccities> findByCountrycity(Bccountries country);

}
