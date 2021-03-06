package br.com.initialproject.service;

import br.com.initialproject.dto.UserDTO;

import java.util.List;

public interface UserService {

	public UserDTO create(UserDTO userDto);

	public List<UserDTO> findAll();

	public UserDTO findById(Long id);

	public UserDTO update(UserDTO userDto);

	public void delete(Long id);

}
