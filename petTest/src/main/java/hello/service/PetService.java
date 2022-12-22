package hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.model.Pet;
import hello.model.Role;
import hello.repository.PetRepository;

@Service
@Transactional
public class PetService {

	@Autowired
	private PetRepository pRepository;
	
	
	
	public void insert(Pet pet) {
		pRepository.save(pet);
	}

	
	

}
