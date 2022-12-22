package hello.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import hello.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@EntityGraph(attributePaths = "role")
	User findByUsername(String username);
}
