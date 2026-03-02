package com.wingbels.belssagecore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bcfunctionality;

@Repository
public interface Bcfunctionalityrepository extends JpaRepository<Bcfunctionality, Long> {

}
