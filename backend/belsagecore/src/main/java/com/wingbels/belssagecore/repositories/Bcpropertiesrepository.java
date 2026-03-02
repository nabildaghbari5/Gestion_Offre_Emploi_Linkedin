package com.wingbels.belssagecore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bcproperties;

@Repository
public interface Bcpropertiesrepository extends JpaRepository<Bcproperties, Long> {

}
