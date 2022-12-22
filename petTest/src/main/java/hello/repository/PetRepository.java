package hello.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import hello.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

	Pet findByPetname(String petname);
	

}