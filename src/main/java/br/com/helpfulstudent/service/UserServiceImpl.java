package br.com.helpfulstudent.service;

import br.com.helpfulstudent.dto.UserDTO;
import br.com.helpfulstudent.exception.ResourceNotFoundException;
import br.com.helpfulstudent.model.User;
import br.com.helpfulstudent.repository.UserRepository;
import br.com.helpfulstudent.util.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	public UserDTO create(UserDTO userDto) {
		User user = DozerConverter.parseObject(userDto, User.class);
		userDto = DozerConverter.parseObject(repository.save(user), UserDTO.class);
		return userDto;
	}

	public List<UserDTO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), UserDTO.class);
	}

	public UserDTO findById(Long id) {

		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(user, UserDTO.class);
	}

	public UserDTO update(UserDTO userDto) {
		repository.findById(userDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		User user = DozerConverter.parseObject(userDto, User.class);

		var vo = DozerConverter.parseObject(repository.save(user), UserDTO.class);
		return vo;
	}

	public void delete(Long id) {
		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(user);
	}
}
