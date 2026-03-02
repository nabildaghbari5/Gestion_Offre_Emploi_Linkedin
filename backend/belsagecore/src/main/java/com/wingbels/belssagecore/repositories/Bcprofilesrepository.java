package com.wingbels.belssagecore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bcprofiles;

@Repository
public interface Bcprofilesrepository extends JpaRepository<Bcprofiles, Long> {

}
