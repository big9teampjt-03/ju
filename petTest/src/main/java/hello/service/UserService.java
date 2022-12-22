package hello.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hello.model.Pet;
import hello.model.Role;
import hello.model.User;
import hello.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepository uRepository;

	public void save(User user) {
		String rawPwd = user.getPassword();
		String encPwd = encoder.encode(rawPwd);
		user.setPassword(encPwd);
		user.setRole(Role.USER);
		uRepository.save(user);
	}
	
	
	public List<User> list() {
		return uRepository.findAll();
	}
	
	public User detail(Long userid) {
		return uRepository.findById(userid).get();
	}
	
	public void delete(Long userid) {
		uRepository.deleteById(userid);
	}
	
	@Transactional
	public void update(User user) {
	String rawPwd = user.getPassword();
	String encPwd = encoder.encode(rawPwd);
	User u = uRepository.findById(user.getUserid()).get();
	u.setNickname(user.getNickname());
	u.setTel(user.getTel());
	u.setUsername(user.getUsername());
	u.setPassword(encPwd);
	}
}