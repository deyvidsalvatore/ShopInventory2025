package com.deyvidsalvatore.shopinventory_api.domain.annotations;

import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UpdateUserPasswordDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, UpdateUserPasswordDTO> {

	@Override
	public boolean isValid(UpdateUserPasswordDTO dto, ConstraintValidatorContext context) {
		if (dto.getNewPassword() == null || dto.getConfirmPassword() == null) {
			return false;
		}
		return dto.getNewPassword().equals(dto.getConfirmPassword());
	}
}