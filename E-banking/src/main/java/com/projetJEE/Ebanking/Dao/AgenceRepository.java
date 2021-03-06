package com.projetJEE.Ebanking.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projetJEE.Ebanking.entities.Agence;
@CrossOrigin("*")
 @RepositoryRestResource
public interface AgenceRepository extends JpaRepository<Agence, Long> {

}
