package com.projetJEE.Ebanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.projetJEE.Ebanking.Dao.AgenceRepository;
import com.projetJEE.Ebanking.Dao.AgentRepository;
import com.projetJEE.Ebanking.Dao.ClientRepository;
import com.projetJEE.Ebanking.Dao.CompteRepository;
import com.projetJEE.Ebanking.entities.Agence;
import com.projetJEE.Ebanking.entities.Agent;
import com.projetJEE.Ebanking.entities.Client;
import com.projetJEE.Ebanking.entities.Compte;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class EBankingApplication implements CommandLineRunner {

	@Autowired
	private AgenceRepository agenceR;
	@Autowired
	private ClientRepository clientR;
	@Autowired
	private CompteRepository compteR;
	@Autowired
	private AgentRepository agentR;
	
	//pour recuperer le id des articles 
	@Autowired
	private RepositoryRestConfiguration rrc;
	
	public static void main(String[] args) {
		SpringApplication.run(EBankingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//pour recuperer le id des articles 
		rrc.exposeIdsFor(Client.class,Compte.class);
		Client c=new Client(null,"Renato","D'OLIVEIRA","MM32323","admin","madagascar","masculin","063233223",null,null,null);
		clientR.save(c);
		clientR.findAll().forEach(client->{
			//ajouter un agent au client
			Agent ag=new Agent(null,RandomString.make(15),"maria",RandomString.make(10),RandomString.make(10),"feminin",null,null);
			client.setAgent(ag);
			agentR.save(ag);
			for(int i=0;i<4;i++){
				//ajouter des comptes au client
				Compte com=new Compte(null,null,"epargne",null,false,null,null,null);
				com.setClient(client);
				compteR.save(com);
			}
		Agence agence1=new Agence(null,null,RandomString.make(15),RandomString.make(15),RandomString.make(15),RandomString.make(15),0);
		agenceR.save(agence1);
		//ajouter des agents aux agences
		agenceR.findAll().forEach(agence->{
			for(int i=0;i<4;i++){
				Agent ag2=new Agent(null,RandomString.make(15),"maria",RandomString.make(10),RandomString.make(10),"feminin",null,null);
				ag2.setAgence(agence);
				agentR.save(ag2);
				
			}
			
		});
		
		
		
		
		
	});

}}
