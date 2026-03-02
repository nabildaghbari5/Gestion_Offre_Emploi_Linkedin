package com.wingbels.belssagecore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bccountries;

@Repository
public interface Bccountriesrepository extends JpaRepository<Bccountries, String>, JpaSpecificationExecutor<Bccountries> {

}
