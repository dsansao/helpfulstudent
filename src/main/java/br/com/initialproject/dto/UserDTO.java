package br.com.initialproject.dto;

import br.com.initialproject.model.enumeration.Gender;
import br.com.initialproject.model.enumeration.Role;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	private String cpf;

	private String password;

	private Date dateOfBirth;

	private String age;

	private Gender gender;

	private Role role;

	private Boolean active;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public UserDTO() {};

	public UserDTO(String username, String email, String cpf, String password, Date dateOfBirth, String age, Gender gender, Role role, Boolean active) {
		this.username = username;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.gender = gender;
		this.role = role;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}