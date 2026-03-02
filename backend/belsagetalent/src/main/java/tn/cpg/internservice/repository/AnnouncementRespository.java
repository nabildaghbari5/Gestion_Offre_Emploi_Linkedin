package tn.cpg.internservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.cpg.internservice.model.Announcement;

@Repository
public interface AnnouncementRespository extends JpaRepository<Announcement, Integer>{

}
