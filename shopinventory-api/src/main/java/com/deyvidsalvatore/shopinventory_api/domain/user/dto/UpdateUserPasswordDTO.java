package com.deyvidsalvatore.shopinventory_api.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import com.deyvidsalvatore.shopinventory_api.domain.annotations.PasswordsMatch;

@PasswordsMatch
public class UpdateUserPasswordDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Current password is required")
	private String oldPassword;

	@NotBlank(message = "New password is required")
	@Size(min = 6, max = 20, message = "New password must be between 6 and 20 characters long")
	private String newPassword;

	@NotBlank(message = "Password confirmation is required")
	private String confirmPassword;

	public UpdateUserPasswordDTO() {
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(confirmPassword, newPassword, oldPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		UpdateUserPasswordDTO other = (UpdateUserPasswordDTO) obj;
		return Objects.equals(confirmPassword, other.confirmPassword)
			&& Objects.equals(newPassword, other.newPassword)
			&& Objects.equals(oldPassword, other.oldPassword);
	}
}
