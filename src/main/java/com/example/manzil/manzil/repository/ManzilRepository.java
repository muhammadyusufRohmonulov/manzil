package com.example.manzil.manzil.repository;

import com.example.manzil.manzil.model.Manzil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "insert")
public interface ManzilRepository extends JpaRepository<Manzil,Integer> {

}
