package com.projetJEE.Ebanking.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projetJEE.Ebanking.entities.Agent;
@CrossOrigin("*")
@RepositoryRestResource
public interface AgentRepository extends JpaRepository<Agent, Long> {

}
