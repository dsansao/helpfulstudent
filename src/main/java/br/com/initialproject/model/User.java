package br.com.initialproject.model;

import br.com.initialproject.model.enumeration.Gender;
import br.com.initialproject.model.enumeration.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = false, length = 200)
	private String username;

	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "email", nullable = false, length = 80)
	private String email;

	@Column(name = "password", nullable = false, length = 80)
	private String password;

	@Column(name = "date_of_birth", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String age;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false, length = 10)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false, length = 10)
	private Role role;

	@Column(name = "active", nullable = false)
	private Boolean active;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public User() {};

	public User(String username, String cpf, String email, String password, Date dateOfBirth, String age, Gender gender, Role role, Boolean active) {
		this.username = username;
		this.cpf = cpf;
		this.email = email;
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