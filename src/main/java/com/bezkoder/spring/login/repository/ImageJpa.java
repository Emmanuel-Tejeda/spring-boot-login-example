package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageJpa extends JpaRepository<ImageModel, String> {

    Optional<ImageModel> findByName(String name);
}
