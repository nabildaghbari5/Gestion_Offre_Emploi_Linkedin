package com.wingbels.belssagecore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bcusers;

@Repository
public interface Bcusersrepository extends JpaRepository<Bcusers, String>, JpaSpecificationExecutor<Bcusers> {

}
