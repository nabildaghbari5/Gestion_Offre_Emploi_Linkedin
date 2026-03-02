package tn.cpg.internservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cpg.internservice.model.ImageModel;

public interface ImageModelRepository extends JpaRepository<ImageModel, Integer> {

    ImageModel findByUserId(String userId);

}
