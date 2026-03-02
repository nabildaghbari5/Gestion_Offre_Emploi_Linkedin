package com.wingbels.belssagecore.repositories;

import com.wingbels.belssagecore.entities.Bccities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bczipcode;

import java.util.Optional;

@Repository
public interface Bczipcoderepository extends JpaRepository<Bczipcode, Long>, JpaSpecificationExecutor<Bczipcode> {

    Optional<Bczipcode> findByCodezipcode(String code);
    Optional<Bczipcode> findByCityzipcode(Bccities city);

}
