package br.com.helpfulstudent.service;

import br.com.helpfulstudent.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

	public User create(User user);

	public List<User> findAll();

	public User findById(Long id);

	public User update(User user);

	public void delete(Long id);

}
