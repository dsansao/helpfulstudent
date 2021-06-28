package br.com.initialproject.service;

import br.com.initialproject.dto.UserDTO;
import br.com.initialproject.exception.ResourceNotFoundException;
import br.com.initialproject.exception.ValidationException;
import br.com.initialproject.model.User;
import br.com.initialproject.repository.UserRepository;
import br.com.initialproject.util.CpfUtil;
import br.com.initialproject.util.DozerConverter;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	public UserDTO create(UserDTO userDto) {
		validateUser(userDto);
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

	private void validateUser(UserDTO user) {

		String erroMsg = "Mandatory fields are empty: ";
		boolean hasError = false;

		if (user.getCpf() == null) {
			erroMsg += "cpf, ";
			hasError = true;
		};

		if (user.getEmail() == null) {
			erroMsg += "email, ";
			hasError = true;
		};

		if (user.getUsername() == null) {
			erroMsg += "username, ";
			hasError = true;
		};

		if (user.getPassword() == null) {
			erroMsg += "password, ";
			hasError = true;
		};

		if (user.getGender() == null) {
			erroMsg += "gender, ";
			hasError = true;
		};

		if (user.getRole() == null) {
			erroMsg += "role, ";
			hasError = true;
		};

		if (!CpfUtil.validaCPF(user.getCpf())) {
			throw new ValidationException("Cpf is not valid");
		}

		if (hasError) {
			throw new ValidationException(erroMsg.substring(0, erroMsg.length() - 2));
		};
	}
}
