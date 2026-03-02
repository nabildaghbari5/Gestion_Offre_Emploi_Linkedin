package com.wingbels.belssagecore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bccontacts;

@Repository
public interface Bccontactsrepository extends JpaRepository<Bccontacts, Long> {

}
