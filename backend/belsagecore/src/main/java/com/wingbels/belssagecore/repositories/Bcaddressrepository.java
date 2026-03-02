package com.wingbels.belssagecore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bcaddress;

@Repository
public interface Bcaddressrepository extends JpaRepository<Bcaddress, Long> {

}
