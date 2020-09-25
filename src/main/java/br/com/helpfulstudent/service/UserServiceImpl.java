package br.com.helpfulstudent.service;

import br.com.helpfulstudent.exception.ResourceNotFoundException;
import br.com.helpfulstudent.model.User;
import br.com.helpfulstudent.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	public User create(User user) {
		return repository.save(user);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public User update(User user) {
		User entity = repository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		this.dtoToEntity(user, entity);

		return repository.save(entity);
	}

	public void delete(Long id) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

	private void dtoToEntity(User user, User entity) {

        BeanUtils.copyProperties(user, entity);
	}
}
