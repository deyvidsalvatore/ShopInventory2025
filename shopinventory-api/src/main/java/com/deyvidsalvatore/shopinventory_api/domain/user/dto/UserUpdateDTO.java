package com.deyvidsalvatore.shopinventory_api.domain.user.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserUpdateDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Role ID is required")
	private Short roleId;

	@NotBlank(message = "First name is required")
	private String firstName;

	private String middleName;

	@NotBlank(message = "Last name is required")
	private String lastName;

	@NotBlank(message = "Username is required")
	private String username;

	@NotBlank(message = "Mobile number is required")
	private String mobile;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;

	public Short getRoleId() {
		return roleId;
	}

	public void setRoleId(Short roleId) {
		this.roleId = roleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof UserUpdateDTO that))
			return false;
		return Objects.equals(roleId, that.roleId) && Objects.equals(firstName, that.firstName)
				&& Objects.equals(lastName, that.lastName) && Objects.equals(username, that.username)
				&& Objects.equals(mobile, that.mobile) && Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleId, firstName, lastName, username, mobile, email);
	}
}
