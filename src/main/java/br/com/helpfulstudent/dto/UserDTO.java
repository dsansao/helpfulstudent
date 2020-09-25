package br.com.helpfulstudent.dto;

import br.com.helpfulstudent.model.enumeration.Gender;
import br.com.helpfulstudent.model.enumeration.UserType;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String email;

	private String password;

	private Date dateOfBirth;

	private String age;

	private Gender gender;

	private UserType userType;

	private Boolean active;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", age='" + age + '\'' +
				", gender=" + gender +
				", userType=" + userType +
				", active=" + active +
				'}';
	}
}